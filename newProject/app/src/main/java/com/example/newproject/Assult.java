package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Assult extends AppCompatActivity {
    EditText edF1, edF2, edF3,edF4;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assult);
        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("FiEmail"))
        {
            Intent intent = new Intent(Assult.this,Submited.class);
            startActivity(intent);
        }


        edF1 = findViewById(R.id.Username);
        edF2 = findViewById(R.id.Gender);
        edF3 = findViewById(R.id.Oconta);
        edF4 = findViewById(R.id.Details);

    }
    public void onClicksubmit(View view)
    {
        String un = edF1.getText().toString();
        String gn = edF2.getText().toString();
        String cn = edF3.getText().toString();
        String cd = edF4.getText().toString();


        BackgroundWorker bgworker = new BackgroundWorker(Assult.this);
        bgworker.execute("assult",un,gn,cn,cd);

        Intent intent = new Intent(Assult.this,Submited.class);
        startActivity(intent);
    }
}