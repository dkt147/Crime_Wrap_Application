package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText ed1, ed2;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("Email")) {
            Intent intent = new Intent(MainActivity2.this, HomePage.class);
            startActivity(intent);
        }

        ed1 = findViewById(R.id.eEmail);
        ed2 = findViewById(R.id.ePass);


    }

    public void loginClicked(View view) {
        String email = ed1.getText().toString();
        String pass = ed2.getText().toString();

        if (email.length() == 0) {
            ed1.requestFocus();
            ed1.setError("FIELD CANNOT BE EMPTY");
        } else if (!email.matches("[a-zA-Z ]+")) {
            ed1.requestFocus();
            ed1.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        } else if (ed2.length() == 0) {
            ed1.requestFocus();
            ed1.setError("FIELD CANNOT BE EMPTY");
        } else {
            Toast.makeText(MainActivity2.this, "Validation Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity2.this, HomePage.class);
            startActivity(intent);

        }
    }

    public void gotoRegister(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(intent);
    }
}

