package com.example.myquran;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myquran.fragment.FragmentHome;

public class SplashActivity extends AppCompatActivity {

    private static int SPALSH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, FragmentHome.class);
                startActivity(intent);
                finish();

            }
        }, SPALSH_TIME_OUT);

    }
}