package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gpbookingapplication.questions.Covid_19_Q1;

public class Corona extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        button = (Button) findViewById(R.id.checker_start_btn);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

            case R.id.checker_start_btn:
                startActivity(new Intent(this, Covid_19_Q1.class));
                break;
        }
    }
}