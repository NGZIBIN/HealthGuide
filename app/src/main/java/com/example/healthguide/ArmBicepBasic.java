package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.health.TimerStat;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class ArmBicepBasic extends AppCompatActivity {
FloatingActionButton btnStart;
CircularView circularViewWithTimer;
MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_bicep_basic);
        this.setTitle("Standing Barbell Curl");
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
                                Toast.makeText(ArmBicepBasic.this, "Break ended continue to the next Exercise / Set! ", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onTimerCancelled() {
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
    }


    public void  btn_start(View view){
        circularViewWithTimer.startTimer();
        if(player == null){
            player = MediaPlayer.create(this, R.raw.music);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    player.release();
                }
            });
        }
        player.start();
    }

    public void  btn_pause(View view){
        if(player != null){
            player.pause();
        }
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
                                Toast.makeText(ArmBicepBasic.this, "Break ended continue to the next Exercise / Set!", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onTimerCancelled() {
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
    }




}
