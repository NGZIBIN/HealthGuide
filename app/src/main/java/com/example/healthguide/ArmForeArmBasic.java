package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class ArmForeArmBasic extends AppCompatActivity {
    CircularView circularViewWithTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_fore_arm_basic);
        circularViewWithTimer = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(30)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(ArmForeArmBasic.this, "Break ended continue to the next Exercise / Set! ", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onTimerCancelled() {
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
    }

    public void  btn_start(View view){
        circularViewWithTimer.startTimer();
    }

    public void  btn_pause(View view){
        if(circularViewWithTimer.pauseTimer())
        {
            //Timer Paused
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
                                Toast.makeText(ArmForeArmBasic.this, "Break ended continue to the next Exercise / Set!", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onTimerCancelled() {
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
    }
}

