package com.example.mylists;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class dbHelperStudent extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "app.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "students"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_fio = "fio";
    public static final String COLUMN_faculty= "faculty";
    public static final String COLUMN_group= "grupa";

    public dbHelperStudent(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(new StringBuilder().append("CREATE TABLE IF NOT EXISTS students (").append(COLUMN_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(COLUMN_fio).append(" TEXT, ").append(COLUMN_faculty).append(" TEXT, ").append(COLUMN_group).append(" TEXT);").toString());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
