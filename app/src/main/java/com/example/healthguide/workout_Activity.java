package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class workout_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_);
        ImageView btnArm = (ImageView) findViewById(R.id.btnArm);
        ImageView btnLeg = (ImageView) findViewById(R.id.btnLeg);
        ImageView btnChest = (ImageView) findViewById(R.id.btnChest);
        ImageView btnBody = (ImageView) findViewById(R.id.btnBody);

        this.setTitle("Workout");
//        btnLeg.findViewById(R.id.btnLeg);
//        btnChest.findViewById(R.id.btnChest);
//        btnBody.findViewById(R.id.btnBody);



//        btnArm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(workout_Activity.this,workoutArm.class);
//                startActivity(intent);
//            }
//        });

//        btnLeg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(workout_Activity.this,workoutleg.class);
//                startActivity(intent);
//            }
//        });
//
//        btnChest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(workout_Activity.this,workoutChest.class);
//                startActivity(intent);
//            }
//        });
//
//        btnBody.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(workout_Activity.this,activityWorkoutFullbody.class);
//                startActivity(intent);
//            }
//        });
    }

    public void goArm(View view) {
        Intent intent = new Intent(workout_Activity.this, workoutArm.class);
                startActivity(intent);
    }
    public void goLeg(View view) {
        Intent intent = new Intent(workout_Activity.this, workoutleg.class);
        startActivity(intent);
    }
    public void goChest(View view) {
        Intent intent = new Intent(workout_Activity.this, workoutChest.class);
        startActivity(intent);
    }
    public void goBody(View view) {
        Intent intent = new Intent(workout_Activity.this, activityWorkoutFullbody.class);
        startActivity(intent);
    }
}
