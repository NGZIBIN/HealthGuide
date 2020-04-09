package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageButton imgBtnHealth;
ImageButton imgBtnWorkout;
ImageButton imgBtnDiet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBtnWorkout = findViewById(R.id.btnWorkout);
        imgBtnDiet = findViewById(R.id.btnDiet);


        imgBtnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,workout_Activity.class);
                startActivity(intent);
            }
        });

        imgBtnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, diet_Activity.class);
                startActivity(intent);
            }
        });
    }
}
