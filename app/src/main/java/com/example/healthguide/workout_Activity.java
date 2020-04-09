package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class workout_Activity extends AppCompatActivity {

    ImageButton btnLeg;
    ImageButton btnArm;
    ImageButton btnBody;
    ImageButton btnChest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_);
        btnArm.findViewById(R.id.btnArm);
        btnLeg.findViewById(R.id.btnLeg);
        btnChest.findViewById(R.id.btnChest);
        btnBody.findViewById(R.id.btnBody);

        btnArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout_Activity.this,workoutArm.class);
                startActivity(intent);
            }
        });

        btnLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout_Activity.this,workoutleg.class);
                startActivity(intent);
            }
        });

        btnChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout_Activity.this,workoutChest.class);
                startActivity(intent);
            }
        });

        btnBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout_Activity.this,activityWorkoutFullbody.class);
                startActivity(intent);
            }
        });
    }
}
