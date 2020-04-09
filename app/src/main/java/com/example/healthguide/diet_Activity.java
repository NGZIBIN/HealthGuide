package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class diet_Activity extends AppCompatActivity {
    ImageButton imgBtnForBody;
    ImageButton imgBtnForVegan;
    ImageButton imgBtnForHealth;
    ImageButton imgBtnForNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_);

        imgBtnForBody.findViewById(R.id.btnDietForBodyBuilding);
        imgBtnForVegan.findViewById(R.id.btnDietVegan);
        imgBtnForHealth.findViewById(R.id.btnDietForHealth);
        imgBtnForNew.findViewById(R.id.btnDietFun);

        imgBtnForBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diet_Activity.this,dietBodySecond.class);
                startActivity(intent);
            }
        });
        imgBtnForHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diet_Activity.this,dietBodyFirst.class);
                startActivity(intent);
            }
        });
        imgBtnForVegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diet_Activity.this,dietBodyThird.class);
                startActivity(intent);
            }
        });

        imgBtnForNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diet_Activity.this,dietBodyForth.class);
                startActivity(intent);
            }
        });
    }
}
