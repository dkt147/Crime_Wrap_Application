package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }
    public void onClick(View view)
    {
        Intent intent;
        switch(view.getId())
        {
            case R.id.mobilS:
                intent = new Intent(Admin.this,MobileSnatch_tbl.class);
                startActivity(intent);
                break;

            case R.id.carS:
                intent = new Intent(Admin.this,carstolen_tbl.class);
                startActivity(intent);
                break;

            case R.id.assult:
                intent = new Intent(Admin.this,assault_tbl.class);
                startActivity(intent);
                break;

            case R.id.violenc:
                intent = new Intent(Admin.this,fir_tbl.class);
                startActivity(intent);
                break;

            case R.id.arson:
                intent = new Intent(Admin.this,arson_tbl.class);
                startActivity(intent);
                break;

            case R.id.kidnap:
                intent = new Intent(Admin.this,kidnap_tbl.class);
                startActivity(intent);
                break;
        }

    }



}