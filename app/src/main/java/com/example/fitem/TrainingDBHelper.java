package com.example.fitem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class TrainingDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trainings.db";
    private static final int DATABASE_VERSION = 1;

    public TrainingDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TRAININGS_TABLE =  "CREATE TABLE " + "trainings" + " ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name" + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_TRAININGS_TABLE);
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

    public void updateTraining(Training training) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", training.getName());
        db.update("trainings", contentValues, "id" + " = ?", new String[] { String.valueOf(training.getId()) });
        db.close();
    }


}