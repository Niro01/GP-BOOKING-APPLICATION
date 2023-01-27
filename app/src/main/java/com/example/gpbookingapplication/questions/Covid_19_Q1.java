package com.example.gpbookingapplication.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gpbookingapplication.Corona;
import com.example.gpbookingapplication.ProfileActivity;
import com.example.gpbookingapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.widget.RadioGroup.*;

public class Covid_19_Q1 extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton floatingActionButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_19__q1);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_btn);
        floatingActionButton.setOnClickListener(this);

        button = (Button) findViewById(R.id.true_Yes_1);
        button.setOnClickListener(this);

        button = (Button) findViewById(R.id.false_No_1);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.preview_btn:
                startActivity(new Intent(this, Corona.class));
                break;

            case R.id.true_Yes_1:
                startActivity(new Intent(this, Covid_19_Q2.class));
                break;

            case R.id.false_No_1:
                startActivity(new Intent(this, Covid_19_Q2.class));
                break;
        }
    }
}