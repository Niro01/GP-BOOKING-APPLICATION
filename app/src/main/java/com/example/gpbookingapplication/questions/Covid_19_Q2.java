package com.example.gpbookingapplication.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gpbookingapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Covid_19_Q2 extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton floatingActionButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_19__q2);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_btn_q2);
        floatingActionButton.setOnClickListener(this);

        button = (Button) findViewById(R.id.false_No);
        button.setOnClickListener(this);

        button = (Button) findViewById(R.id.true_Yes);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.preview_btn_q2:
                startActivity(new Intent(this, Covid_19_Q1.class));
                break;

            case R.id.false_No:
                startActivity(new Intent(this, Covid_19_Q3.class));
                break;

            case R.id.true_Yes:
                startActivity(new Intent(this, Covid_19_Q4.class));
                break;
        }
    }
}