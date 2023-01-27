package com.example.gpbookingapplication.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gpbookingapplication.Corona;
import com.example.gpbookingapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class Covid_19_Q4 extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton floatingActionButton;
    private EditText editTextDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_19__q4);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_btn);
        floatingActionButton.setOnClickListener(this);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.next_btn);
        floatingActionButton.setOnClickListener(this);

        editTextDay = (EditText) findViewById(R.id.Days);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.preview_btn:
                startActivity(new Intent(this, Covid_19_Q3.class));
                break;

            case R.id.next_btn:
                nextbtn();
                break;

        }
    }

    private void nextbtn() {
        String day = editTextDay.getText().toString().trim();

        if(day.isEmpty()){
            editTextDay.setError("Days is Required!");
            editTextDay.requestFocus();
            return;
        }
        if(day.length() > 1){
            editTextDay.setError("Enter Correct Days");
            editTextDay.requestFocus();
            return;
        }
      startActivity(new Intent(this, Covid_19_Q5.class));
    }
}