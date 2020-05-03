package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class splashActivity extends AppCompatActivity {

    CircularView circularView;
private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent homeIntent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);


        circularView = findViewById(R.id.circular_view);

        CircularView.OptionsBuilder builderWithoutText =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(false)
                        .setCounterInSeconds(CircularView.OptionsBuilder.INFINITE);


        circularView.setOptions(builderWithoutText);
        circularView.startTimer();
    }
}
