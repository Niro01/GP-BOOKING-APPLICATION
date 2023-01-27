package com.example.gpbookingapplication.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gpbookingapplication.Corona;
import com.example.gpbookingapplication.ProfileActivity;
import com.example.gpbookingapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Covid_19_Q5 extends AppCompatActivity implements View.OnClickListener {

    Button button;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_19__q5);

        button = (Button) findViewById(R.id.finish_btn);
        button.setOnClickListener(this);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_btn);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_btn:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

            case R.id.preview_btn:
                startActivity(new Intent(this, Covid_19_Q4.class));
                break;
        }
    }
}