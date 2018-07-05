package com.example.dell.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void register(View v){
        Intent i=new Intent(this, register.class);
        startActivity(i);
    }
    public void login(View e){
        Intent j=new Intent(this, login.class);
        startActivity(j);

    }
}
