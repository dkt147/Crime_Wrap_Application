package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirForm extends AppCompatActivity {
    EditText edF1, edF2, edF3;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir_form);

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("FiEmail"))
        {
            Intent intent = new Intent(FirForm.this,Submited.class);
            startActivity(intent);
        }


        edF1 = findViewById(R.id.Username);
        edF2 = findViewById(R.id.Email);
        edF3 = findViewById(R.id.Oconta);

    }
     public void onClicksubmit(View view)
     {
         String un = edF1.getText().toString();
         String gn = edF2.getText().toString();
         String cn = edF3.getText().toString();


         BackgroundWorker bgworker = new BackgroundWorker(FirForm.this);
         bgworker.execute("fir",un,gn,cn);

         Intent intent = new Intent(FirForm.this,Submited.class);
         startActivity(intent);
     }
     }
