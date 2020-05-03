package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class workoutChest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_chest);


    }

    public void GoBasic1(View view){
        Intent intent = new Intent(workoutChest.this,ChestBasic1.class);
        startActivity(intent);
    }

    public void GoBasic2(View view){
        Intent intent = new Intent(workoutChest.this,ChestBasic2.class);
        startActivity(intent);
    }

    public void GoAdvance1(View view){
        Intent intent = new Intent(workoutChest.this,ChestAdvance1.class);
        startActivity(intent);
    }

    public void GoAdvance2(View view){
        Intent intent = new Intent(workoutChest.this,ChestAdvance2.class);
        startActivity(intent);
    }


}
