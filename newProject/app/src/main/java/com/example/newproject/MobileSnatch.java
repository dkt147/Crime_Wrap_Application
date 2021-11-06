package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MobileSnatch extends AppCompatActivity {

    EditText edF1,edF2,edF3,edF4;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_snatch);

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("Ename"))
        {
            Intent intent = new Intent(MobileSnatch.this,Submited.class);
            startActivity(intent);
        }



        edF1 = findViewById(R.id.Username);
        edF2 = findViewById(R.id.gende);
        edF3 = findViewById(R.id.Oconta);
        edF4 = findViewById(R.id.snatch);

    }
    public void submitClicked(View view)
    {
        String un = edF1.getText().toString();
        String gen= edF2.getText().toString();
        String con= edF3.getText().toString();
        String snp= edF4.getText().toString();


        BackgroundWorker bgworker = new BackgroundWorker(MobileSnatch.this);
        bgworker.execute("mobilesnatch",un,gen,con,snp);

        Intent intent = new Intent(MobileSnatch.this,Submited.class);
        startActivity(intent);

    }

}