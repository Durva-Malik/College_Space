package com.example.ikgptulite;


import static android.os.Build.VERSION_CODES.M;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        new Handler().postDelayed(new Runnable() {

            public void run() {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                //Intent is used to switch from one activity to another.
                startActivity(i);

                //invoke the SecondActivity.
                finish();
                Toast.makeText(MainActivity.this, "WELCOME ONBOARD !", Toast.LENGTH_SHORT).show();
                //the current activity will get finished.
            }
        }, 1000);
    }


}
