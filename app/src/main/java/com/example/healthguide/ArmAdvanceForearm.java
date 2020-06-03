package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class ArmAdvanceForearm extends AppCompatActivity {

    FloatingActionButton btnStart;
    CircularView circularViewWithTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Single Arm Barbell Raise");
        setContentView(R.layout.activity_arm_advance_forearm);
        circularViewWithTimer = findViewById(R.id.circular_view);
        btnStart = findViewById(R.id.start);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(30)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(ArmAdvanceForearm.this, "Break ended continue to the next Exercise / Set! ", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onTimerCancelled() {
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circularViewWithTimer.startTimer();
            }
        });
    }

//    public void  btn_start(View view){
//
//        circularViewWithTimer.startTimer();
//    }


    public void  btn_pause(View view){
        if(circularViewWithTimer.pauseTimer())
        {
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    circularViewWithTimer.resumeTimer();
                }
            });
        }
    }

    public void  btn_reset(View view){
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(30)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(ArmAdvanceForearm.this, "Break ended continue to the next Exercise / Set!", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onTimerCancelled() {
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
    }
}

