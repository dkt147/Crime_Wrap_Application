package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtherCrimes extends AppCompatActivity {

    EditText edo1,edo2,edo3,edo4;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_crimes);

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("OEmail"))
        {
            Intent intent = new Intent(OtherCrimes.this,Submited.class);
            startActivity(intent);
        }
          edo1 = findViewById(R.id.Username);
        edo2 = findViewById(R.id.Email);
        edo3 = findViewById(R.id.Oconta);
        edo4 = findViewById(R.id.OCrime);


    }

    public void onClicksubmit(View view)
    {

        String un = edo1.getText().toString();
        String gn = edo2.getText().toString();
        String cn = edo3.getText().toString();
        String cd = edo4.getText().toString();


        BackgroundWorker bgworker = new BackgroundWorker(OtherCrimes.this);
        bgworker.execute("othercrimes",un,gn,cn,cd);

        Intent intent = new Intent(OtherCrimes.this,Submited.class);
        startActivity(intent);

    }

    public void onClickBack(View view)
    {
        Intent intent = new Intent(OtherCrimes.this,HomePage.class);
        startActivity(intent);

    }
}