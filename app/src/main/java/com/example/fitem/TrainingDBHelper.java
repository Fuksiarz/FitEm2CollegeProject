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
    private static final String DATABASE_NAME = "trainings.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_EXERCISES = "exercises";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_REPETITIONS = "repetitions";
    private static final String KEY_SETS = "sets";
    private static final String KEY_COUNTDOWN_TIME = "countdownTime";


    public TrainingDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TRAININGS_TABLE =  "CREATE TABLE " + "trainings" + " ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name" + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_TRAININGS_TABLE);

        String CREATE_EXERCISES_TABLE = "CREATE TABLE IF NOT EXISTS exercises ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "repetitions INTEGER,"
                + "sets INTEGER,"
                + "restTime INTEGER,"
                + "trainingId INTEGER,"
                + "FOREIGN KEY(trainingId) REFERENCES trainings(id)" + ")";

        db.execSQL(CREATE_EXERCISES_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "trainings");
        onCreate(db);
    }
    public void insertTraining(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        db.insert("trainings", null, contentValues);
        db.close();
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
                trainingList.add(training);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return trainingList;
    }

    public void deleteTraining(Training training) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("trainings", "id" + " = ?", new String[] { String.valueOf(training.getId()) });
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
    public boolean addExerciseToTraining(Exercise exercise, Training training) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", exercise.getName());
        contentValues.put("trainingId", training.getId());
        long result = db.insert("exercises", null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }
    public List<Exercise> getAllExercisesForTraining(int trainingId) {
        List<Exercise> exerciseList = new ArrayList<>();

        // Select all query
        String selectQuery = "SELECT  * FROM " + TABLE_EXERCISES + " WHERE " + "trainingId" + " = " + trainingId;

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