package com.example.healthguide;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.math.BigDecimal;

public class BMI_calculator extends AppCompatActivity {

    EditText etHeight, etWeight, etAge;
    Button btnSubmit;
    RadioGroup gender;
    TextView result, bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        this.setTitle("BMI Calculator");

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        etAge = findViewById(R.id.etAge);
        btnSubmit = findViewById(R.id.btnSubmit);
        gender = findViewById(R.id.GenderRadioGroup);
        result = findViewById(R.id.result);
        bmiResult = findViewById(R.id.bmiResult);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = etHeight.getText().toString();
                String weight = etWeight.getText().toString();
                String age = etAge.getText().toString();

                float fHeight = Float.parseFloat(height)/100;
                float fWeight = Float.parseFloat(weight);
                int intAge = Integer.parseInt(age);

                float bmi = fWeight / (fHeight * fHeight);

                if(height.isEmpty()){
                    etHeight.setError("Please enter a height");
                }
                else if (weight.isEmpty()){
                    etWeight.setError("Please enter a weight");
                }
                else if(age.isEmpty()){
                    etAge.setError("Please enter a age");
                }

                BigDecimal results;
                results=round(bmi,2);
                String resultsBMI = String.valueOf(results);
                bmiResult.setText(resultsBMI);

                switch (gender.getCheckedRadioButtonId()){
                    case R.id.femaleBtn:
                            if(intAge < 19){
                                if(bmi < 21 ){
                                    result.setText("You are severely Overweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else if(bmi < 19){
                                    result.setText("You are Overweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else if(bmi < 14){
                                    result.setText("Your weight is acceptable");
                                    result.setTextColor(Color.parseColor("#008000"));
                                    bmiResult.setTextColor(Color.parseColor("#008000"));
                                }
                                else if(bmi < 13){
                                    result.setText("You are Underweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else{
                                    result.setText("You are severely Underweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                            }else{
                                if(bmi < 18.5){
                                    result.setText("You are Underweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else if(bmi > 18.5 && bmi < 24.9){
                                    result.setText("You are in a Healthy Weight Range!");
                                    result.setTextColor(Color.parseColor("#008000"));
                                    bmiResult.setTextColor(Color.parseColor("#008000"));
                                }
                                else if(bmi > 25 && bmi < 29.9){
                                    result.setText("You are overweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else{
                                    result.setText("You are in obese range!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                            }
                        break;
                    case R.id.maleBtn:
                            if(intAge < 19){
                                if(bmi < 13 ){
                                    result.setText("You are severely Underweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else if(bmi < 13.3){
                                    result.setText("You are Underweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else if(bmi < 19){
                                    result.setText("Your weight is acceptable");
                                    result.setTextColor(Color.parseColor("#008000"));
                                    bmiResult.setTextColor(Color.parseColor("#008000"));
                                }
                                else if(bmi < 22){
                                    result.setText("You are Overweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else{
                                    result.setText("You are severely Overweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                            }
                            else {
                                if(bmi < 18.5){
                                    result.setText("You are Underweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else if(bmi > 18.5 && bmi < 24.9){
                                    result.setText("You are in a Healthy Weight Range!");
                                    result.setTextColor(Color.parseColor("#008000"));
                                    bmiResult.setTextColor(Color.parseColor("#008000"));
                                }
                                else if(bmi > 25 && bmi < 29.9){
                                    result.setText("You are overweight!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                                else{
                                    result.setText("You are in obese range!");
                                    result.setTextColor(Color.parseColor("#FF0000"));
                                    bmiResult.setTextColor(Color.parseColor("#FF0000"));
                                }
                            }

                        break;
                }
            }
        });

    }
    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}
