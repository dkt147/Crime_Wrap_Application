package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Submited extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submited);

        button = (Button) findViewById(R.id.Back);

        Intent intent = new Intent(Submited.this,HomePage.class);
        startActivity(intent);



    }
}