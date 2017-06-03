package com.joshking.adapter;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Joshking on 2017/6/3.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    public MyOpenHelper(Context context) {
        super(context, "mydate", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mybook(ids integer PRIMARY KEY autoincrement,title text,content text,times text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
