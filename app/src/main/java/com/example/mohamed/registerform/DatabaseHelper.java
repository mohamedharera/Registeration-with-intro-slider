package com.example.mohamed.registerform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mohamed on 7/23/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "RegisterDb";
    public static final int DATABASE_VERSION = 1;

    public static final String Table_Name="register";
    public static final String Col_1 ="ID" ;
    public static final String Col_2 ="FirstName" ;
    public static final String Col_3 ="LastName" ;
    public static final String Col_4 ="Password" ;
    public static final String Col_5 ="Email" ;
    public static final String Col_6 ="Phone" ;

    public static final String INST_TABLE="Instregister";
    public static final String Col_id ="Id" ;
    public static final String Col_name ="Name" ;
    public static final String Col_last ="Last" ;
    public static final String Col_pass ="Pass" ;
    public static final String Col_email ="EMAIL" ;
    public static final String Col_phone ="PHONE" ;


    public DatabaseHelper(Context context) {
        super(context,Database_Name, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,Password TEXT,Email TEXT,Phone TEXT)");
        db.execSQL("CREATE TABLE " + INST_TABLE + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Last TEXT,Pass TEXT,EMAIL TEXT,PHONE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+ Table_Name);
        db.execSQL("DROP TABLE IF EXISTS"+ INST_TABLE);
        onCreate(db);
    }


}
