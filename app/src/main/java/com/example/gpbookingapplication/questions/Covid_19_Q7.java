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

public class Covid_19_Q7 extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton floatingActionButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_19__q7);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_btn);
        floatingActionButton.setOnClickListener(this);

        button = (Button) findViewById(R.id.finish_btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.preview_btn:
            startActivity(new Intent(this, Covid_19_Q6.class));
            break;

            case R.id.finish_btn:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

        }
    }
}