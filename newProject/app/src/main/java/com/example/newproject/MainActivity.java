package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread timer = new Thread() {

            @Override
            public void run()
            {
                 int currentStatus = 0;

              try {
                  while (currentStatus <= 100) {
                       if(currentStatus == 100)

                       {
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                       }

                       Thread.sleep(400);
                       currentStatus += 10;
                  }
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

            }
        };
        timer.start();
        




       }
}