package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activityWorkoutFullbody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_fullbody);
    }

    public void BodyBasic1(View view){
        Intent intent = new Intent(activityWorkoutFullbody.this,BodyBasic1.class);
        startActivity(intent);
    }

    public void BodyBasic2(View view){
        Intent intent = new Intent(activityWorkoutFullbody.this,BodyBasic2.class);
        startActivity(intent);
    }

    public void BodyAdvance1(View view){
        Intent intent = new Intent(activityWorkoutFullbody.this,BodyAdvance1.class);
        startActivity(intent);
    }

    public void BodyAdvance2(View view){
        Intent intent = new Intent(activityWorkoutFullbody.this,BodyAdvance2.class);
        startActivity(intent);
    }
}
