package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CarSnatch extends AppCompatActivity {
    EditText edF1, edF2, edF3, edF4;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_snatch);

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);


        edF1 = findViewById(R.id.Username);
        edF2 = findViewById(R.id.Gender);
        edF3 = findViewById(R.id.Oconta);
        edF4 = findViewById(R.id.Description);
    }
    public void onClicksubmit(View view)
    {
        String un = edF1.getText().toString();
        String gn = edF2.getText().toString();
        String cn = edF3.getText().toString();
        String cd = edF4.getText().toString();



        BackgroundWorker bgworker = new BackgroundWorker(CarSnatch.this);
        bgworker.execute("carsnatch",un,gn,cn,cd);

        Intent intent = new Intent(CarSnatch.this,Submited.class);
        startActivity(intent);
    }


}