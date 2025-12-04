package com.example.lab7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper instance;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Singleton
    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + FriendsContract.TABLE_NAME + " (" +
                FriendsContract.Columns._ID + " INTEGER PRIMARY KEY, " +
                FriendsContract.Columns.NAME + " TEXT NOT NULL, " +
                FriendsContract.Columns.EMAIL + " TEXT, " +
                FriendsContract.Columns.PHONE + " TEXT NOT NULL)";
        db.execSQL(createTable);

        db.execSQL("INSERT INTO " + FriendsContract.TABLE_NAME +
                "(" + FriendsContract.Columns.NAME + ", " + FriendsContract.Columns.PHONE + ") " +
                "VALUES ('Alice', '+380501234567');");

        db.execSQL("INSERT INTO " + FriendsContract.TABLE_NAME +
                "(" + FriendsContract.Columns.NAME + ", " + FriendsContract.Columns.EMAIL + ", " +
                FriendsContract.Columns.PHONE + ") VALUES ('Charlie', 'charlie@mail.com', '+380671112233');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
