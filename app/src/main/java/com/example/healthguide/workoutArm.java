package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class workoutArm extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_arm);


    }
    public void startWorkoutArmBicep(View view) {
        Intent intent = new Intent(workoutArm.this,ArmBicepBasic.class);
        startActivity(intent);
    }
    public void startWorkoutBasicForearm(View view) {
        Intent intent = new Intent(workoutArm.this,ArmBiceptAdvance.class);
        startActivity(intent);
    }

    public void startWorkoutAdvanceBicepArm(View view) {
        Intent intent = new Intent(workoutArm.this,ArmForeArmBasic.class);
        startActivity(intent);
    }


    public void startWorkoutAdvanceForearm(View view) {
        Intent intent = new Intent(workoutArm.this,ArmAdvanceForearm.class);
        startActivity(intent);
    }

}
