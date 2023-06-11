package com.example.fitem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TrainingDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Baza.db";

//    private static final String DATABASE_NAME = "new_trainings.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_EXERCISES = "exercises";
    private static final String KEY_ID = "id";

    private static final String KEY_TRAINING_ID = "training_Id";
    private static final String KEY_NAME = "name";
    private static final String KEY_REPETITIONS = "repetitions";
    private static final String KEY_SETS = "sets";
    private static final String KEY_COUNTDOWN_TIME = "countdownTime";


    public TrainingDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tworzenie tabeli trainings
        String SQL_CREATE_TRAININGS_TABLE = "CREATE TABLE IF NOT EXISTS " + "trainings" + " ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name" + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_TRAININGS_TABLE);

        // Tworzenie tabeli exercises
        String CREATE_EXERCISES_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_EXERCISES + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_REPETITIONS + " INTEGER,"
                + KEY_SETS + " INTEGER,"
                + "restTime INTEGER,"
                + KEY_TRAINING_ID + " INTEGER,"
                + "countdownTime INTEGER,"
                + "FOREIGN KEY(" + KEY_TRAINING_ID + ") REFERENCES trainings(id)" + ")";
        db.execSQL(CREATE_EXERCISES_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//         Kod do resetowania tabeli
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
            onCreate(db);
        }
    }
    public long insertTraining(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long id = db.insert("trainings", null, contentValues);
        db.close();
        return id;
    }

    public List<Training> getAllTrainings() {
        List<Training> trainingList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + "trainings";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Training training = new Training();
                training.setId(Integer.parseInt(cursor.getString(0)));
                training.setName(cursor.getString(1));
                Log.d("TrainingDBHelper", "Cwiczenie: " + cursor.getString(1) + " o id: " + cursor.getString(0));
                trainingList.add(training);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return trainingList;
    }

    public void deleteTraining(int trainingId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("exercises", "training_id = ?", new String[]{String.valueOf(trainingId)});


        db.delete("trainings", "id = ?", new String[] { String.valueOf(trainingId) });
        db.close();
    }

    public void deleteExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Usuń ćwiczenie
        db.delete(TABLE_EXERCISES, KEY_ID + " = ?", new String[]{String.valueOf(exercise.getId())});

        db.close();
    }

    public void updateTraining(Training training) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", training.getName());
        db.update("trainings", contentValues, "id" + " = ?", new String[] { String.valueOf(training.getId()) });
        db.close();
    }

    public Exercise getExerciseById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EXERCISES,
                new String[] { KEY_ID, KEY_NAME, KEY_REPETITIONS, KEY_SETS, KEY_COUNTDOWN_TIME },
                KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Exercise exercise = new Exercise();

            // Konwersja id
            String idString = cursor.getString(0);
            if (idString != null && !idString.isEmpty()) {
                try {
                    exercise.setId(Integer.parseInt(idString));
                } catch (NumberFormatException nfe) {
                    Log.e("NumberFormatException", "Could not parse " + nfe);
                }
            }

            // Konwersja name
            exercise.setName(cursor.getString(1));

            // Konwersja repetitions
            String repetitionsString = cursor.getString(2);
            if (repetitionsString != null && !repetitionsString.isEmpty()) {
                try {
                    exercise.setRepetitions(Integer.parseInt(repetitionsString));
                } catch (NumberFormatException nfe) {
                    Log.e("NumberFormatException", "Could not parse " + nfe);
                }
            }

            // Konwersja sets
            String setsString = cursor.getString(3);
            if (setsString != null && !setsString.isEmpty()) {
                try {
                    exercise.setSets(Integer.parseInt(setsString));
                } catch (NumberFormatException nfe) {
                    Log.e("NumberFormatException", "Could not parse " + nfe);
                }
            }

            // Konwersja countdownTime
            String countdownTimeString = cursor.getString(4);
            if (countdownTimeString != null && !countdownTimeString.isEmpty()) {
                try {
                    exercise.setCountdownTime(Integer.parseInt(countdownTimeString));
                } catch (NumberFormatException nfe) {
                    Log.e("NumberFormatException", "Could not parse " + nfe);
                }
            }

            cursor.close();
            db.close();
            return exercise;

        } else {
            return null;
        }
    }

    public boolean addExerciseToTraining(Exercise exercise, Training training) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, exercise.getName());
        contentValues.put(KEY_TRAINING_ID, training.getId());

        long result = db.insert(TABLE_EXERCISES, null, contentValues);
        db.close();
        Log.d("TrainingDBHelper", "Dodawanie ćwiczenia " + exercise.getName() + " do treningu: " + training.getName() + " o id: " + training.getId());

        if (result == -1) {

            return false;

        } else {
            return true;
        }

    }
    public int updateExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        int rowsAffected = 0;
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_NAME, exercise.getName());
            values.put(KEY_REPETITIONS, exercise.getRepetitions());
            values.put(KEY_SETS, exercise.getSets());
            values.put(KEY_COUNTDOWN_TIME, exercise.getCountdownTime());

            rowsAffected = db.update(TABLE_EXERCISES, values, KEY_ID + " = ?", new String[] { String.valueOf(exercise.getId()) });

            db.setTransactionSuccessful();

        } finally {
            db.endTransaction();
            db.close();
        }
        return rowsAffected;
    }
    public void deleteExercisesForTraining(int trainingId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXERCISES, KEY_TRAINING_ID + " = ?", new String[] { String.valueOf(trainingId) });
        db.close();
    }

    public List<Exercise> getAllExercisesForTraining(int trainingId) {


        List<Exercise> exerciseList = new ArrayList<>();

        // Select all query
        String selectQuery = "SELECT  * FROM " + TABLE_EXERCISES + " WHERE " + KEY_TRAINING_ID + " = " + trainingId;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Przechodzenie przez wszystkie rzędy i dodawanie do listy
        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();

                // Konwersja id
                String idString = cursor.getString(0);
                if (idString != null && !idString.isEmpty()) {
                    try {
                        exercise.setId(Integer.parseInt(idString));
                    } catch (NumberFormatException nfe) {
                        Log.e("NumberFormatException", "Could not parse " + nfe);
                    }
                }

                // Konwersja name
                exercise.setName(cursor.getString(1));

                // Konwersja repetitions
                String repetitionsString = cursor.getString(2);
                if (repetitionsString != null && !repetitionsString.isEmpty()) {
                    try {
                        exercise.setRepetitions(Integer.parseInt(repetitionsString));
                    } catch (NumberFormatException nfe) {
                        Log.e("NumberFormatException", "Could not parse " + nfe);
                    }
                }

                // Konwersja sets
                String setsString = cursor.getString(3);
                if (setsString != null && !setsString.isEmpty()) {
                    try {
                        exercise.setSets(Integer.parseInt(setsString));
                    } catch (NumberFormatException nfe) {
                        Log.e("NumberFormatException", "Could not parse " + nfe);
                    }
                }

                // Konwersja countdownTime
                String countdownTimeString = cursor.getString(4);
                if (countdownTimeString != null && !countdownTimeString.isEmpty()) {
                    try {
                        exercise.setCountdownTime(Integer.parseInt(countdownTimeString));
                    } catch (NumberFormatException nfe) {
                        Log.e("NumberFormatException", "Could not parse " + nfe);
                    }
                }

                // Konwersja trainingId
                String trainingIdString = cursor.getString(5);
                if (trainingIdString != null && !trainingIdString.isEmpty()) {
                    try {
                        exercise.setTrainingId(Integer.parseInt(trainingIdString));
                    } catch (NumberFormatException nfe) {
                        Log.e("NumberFormatException", "Could not parse " + nfe);
                    }
                }

                // Dodanie ćwiczenia do listy
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }
        return exerciseList;
    }



}