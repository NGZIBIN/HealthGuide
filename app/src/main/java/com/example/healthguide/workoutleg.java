package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class workoutleg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutleg);
        this.setTitle("Leg Workout");
    }

    public void LegBasic1(View view){
        Intent intent = new Intent(workoutleg.this,LegBasic1.class);
        startActivity(intent);
    }

    public void LegAdvance1(View view){
        Intent intent = new Intent(workoutleg.this,LegAdvance1.class);
        startActivity(intent);
    }
}
