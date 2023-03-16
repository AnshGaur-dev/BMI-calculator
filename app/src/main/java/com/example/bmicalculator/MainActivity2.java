package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout llMain;
        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate,btnrestart,btnexit;

        btnexit = findViewById(R.id.exit);
        btnrestart= findViewById(R.id.restart);
        Intent intent= new Intent(MainActivity2.this,MainActivity.class);

        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        edtWeight=findViewById(R.id.edtweight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt= Integer.parseInt( edtWeight.getText().toString());
                int ft=Integer.parseInt( edtHeightFt.getText().toString());
                int in=Integer.parseInt( edtHeightIn.getText().toString());
                int totalIn= ft*12+in;
                double totalCm=totalIn*2.53;
                double totalM=totalCm/100;
                double bmi=wt/(totalM*totalM);
                if (bmi>25){
                    txtResult.setText("You are overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.color_ow));
                } else if (bmi < 18) {
                    txtResult.setText("You are underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.color_uw));
                }
                else {
                    txtResult.setText("You're healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.color_h));
                }

            }
        });





    }
}