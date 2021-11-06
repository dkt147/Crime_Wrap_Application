package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    EditText edi1,edi2,edi3,edi4,edi5;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("Ename"))
        {
            Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
            startActivity(intent);
        }

         edi1 = findViewById(R.id.Username);
         edi2 = findViewById(R.id.Password);
         edi3 = findViewById(R.id.Email);
         edi4 = findViewById(R.id.Age);
         edi5 = findViewById(R.id.Contact);

    }

    public void registerClicked(View view)
    {
        String un = edi1.getText().toString();
        String ps= edi2.getText().toString();
        String em= edi3.getText().toString();
        String ag= edi4.getText().toString();
        String cn= edi5.getText().toString();

        BackgroundWorker bgworker = new BackgroundWorker(MainActivity3.this);
        bgworker.execute("register",un,ps,em,ag,cn);

        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);

    }

    public void onlogin(View view) {
    }
}