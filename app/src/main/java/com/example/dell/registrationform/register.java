package com.example.dell.registrationform;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.dell.registrationform.database.col_1;
import static com.example.dell.registrationform.database.col_2;
import static com.example.dell.registrationform.database.col_3;
import static com.example.dell.registrationform.database.col_4;
import static com.example.dell.registrationform.database.col_5;
import static com.example.dell.registrationform.database.col_6;
import static com.example.dell.registrationform.database.table_name;

public class register extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText editsurname, editlastname, editpassword, editdob, editschool, editdepartment;
    String surname, lastname, password, dob, school, department;
    Button mybutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper=new database(this);

        editsurname = (EditText) findViewById(R.id.mysurname);
        editlastname = (EditText) findViewById(R.id.mylastname);
        editpassword = (EditText) findViewById(R.id.mypassword);
        editdob = (EditText) findViewById(R.id.mydob);
        editschool = (EditText) findViewById(R.id.mysch);
        editdepartment = (EditText) findViewById(R.id.mydept);
        mybutton = (Button) findViewById(R.id.submit);
        mybutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sqLiteDatabase=openHelper.getWritableDatabase();
                        registers();
                    }
                }
        );
    }
    public void insertdata(String surname, String lastname, String password, String dob, String school, String department) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, surname);
        contentValues.put(col_2, lastname);
        contentValues.put(col_3, password);
        contentValues.put(col_4, dob);
        contentValues.put(col_5, school);
        contentValues.put(col_6, department);

        long result = sqLiteDatabase.insert(table_name, null, contentValues);
    }


    public void onsignupsuccess(){
        }
        public  boolean validate(){
            boolean valid=false;
            
            if(surname.isEmpty()|| surname.length()>30)
                editsurname.setError("surname required");


            else if(lastname.isEmpty()|| lastname.length()>30)
                editlastname.setError("lastname required");

            else if(password.isEmpty()|| password.length()>30)
                editpassword.setError("enter valid password");

            else if(dob.isEmpty()|| dob.length()>30)
                editdob.setError("dob required");

            else if(school.isEmpty()|| school.length()>30)
                editschool.setError("school required");

            else if(department.isEmpty()|| department.length()>30)
                editdepartment.setError("department required");

            else
                 {
                Intent i = new Intent(register.this, successful.class);
                startActivity(i);
                valid=true;
            }

            return valid;


        }
        public void registers(){
            initialize();
            if(!validate())
                Toast.makeText(register.this,"Sign up has failed", Toast.LENGTH_LONG).show();
            else
                onsignupsuccess();
        }


    public void initialize(){
        surname=editsurname.getText().toString();
        lastname=editlastname.getText().toString();
        password=editpassword.getText().toString();
        dob=editdob.getText().toString();
        school=editschool.getText().toString();
        department=editdepartment.getText().toString();

    }
}
