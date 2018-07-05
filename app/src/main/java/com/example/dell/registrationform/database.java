package com.example.dell.registrationform;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper{
    public static final String database_name="registration.db";
    public static final String table_name="registration_form";
    public static final String col_1="surname";
    public static final String col_2="lastname";
    public static final String col_3="password";
    public static final String col_4="dob";
    public static final String col_5="school";
    public static final String col_6="department";
    public static final String col_7="id";

    public database(Context context) {
        super(context, database_name,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + table_name + "(id INTEGER PRIMARY KEY AUTOINCREMENT,surname TEXT,lastname TEXT, password TEXT,dob TEXT, school TEXT,department TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(sqLiteDatabase);



    }
}

















