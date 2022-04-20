package com.example.snapchat.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "snapchat.db";
    public final static int DATABASE_VERSION = 1;

    public final static String FRIENDS = "Friends";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String TIME = "time";

    private static DBOpenHelper db = null;

    private DBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = new DBOpenHelper(context).getWritableDatabase();
    }
    public static DBOpenHelper getInstance(Context context)
    {
        return db = (db == null) ? new DBOpenHelper(context) : db;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE "+ FRIENDS + "(" +
                ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                NAME + " TEXT NOT NULL," +
                TIME + " TIME NOT NULL)");
        Log.d("Query", query);
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
