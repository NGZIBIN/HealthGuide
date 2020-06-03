package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class diet_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_);
        this.setTitle("Diet");
    }
    public void goBodyBuilding(View view) {
        Intent intent = new Intent(diet_Activity.this,dietBodySecond.class);
        startActivity(intent);
    }
    public void goHealth(View view) {
        Intent intent = new Intent(diet_Activity.this,dietBodyFirst.class);
        startActivity(intent);
    }
    public void goVegan(View view) {
        Intent intent = new Intent(diet_Activity.this,dietBodyThird.class);
        startActivity(intent);
    }
    public void goDietFun(View view) {
        Intent intent = new Intent(diet_Activity.this,dietBodyForth.class);
        startActivity(intent);
    }
}
