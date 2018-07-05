package com.example.dell.registrationform;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper openHelper;
    EditText mysurname, mypassword;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mysurname = (EditText) findViewById(R.id.surnamelogin);
        mypassword = (EditText) findViewById(R.id.passwordlogin);
        openHelper = new database(this);
        sqLiteDatabase = openHelper.getReadableDatabase();
    }

    public void signclick(View v) {
        String sur = mysurname.getText().toString();
        String pass = mypassword.getText().toString();
        cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + database.table_name + " WHERE " + database.col_1 + "=? AND " + database.col_3 + "=? ", new String[]{sur, pass});
        if (cursor != null) {
            if (cursor.getCount() > 0){
                cursor.moveToNext();
            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
        }   else {
                Toast.makeText(getApplicationContext(), "Enter valid surname and password",Toast.LENGTH_LONG).show();
                }
            }
        }
    }


