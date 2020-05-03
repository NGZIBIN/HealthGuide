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
ImageView imgBtnWorkout;
ImageButton imgBtnDiet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBtnWorkout = findViewById(R.id.btnWorkout);
        imgBtnDiet = findViewById(R.id.btnDiet);






        imgBtnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, diet_Activity.class);
                startActivity(intent);
            }
        });
    }
    public void goWorkout(View view) {
        Intent intent = new Intent(MainActivity.this,workout_Activity.class);
                startActivity(intent);
    }

    public void goBMI(View view) {
        Intent intent = new Intent(MainActivity.this,BMI_calculator.class);
        startActivity(intent);
    }

    public void goGallery(View view) {
        Intent intent = new Intent(MainActivity.this,NoteActivity.class);
        startActivity(intent);
    }
}
