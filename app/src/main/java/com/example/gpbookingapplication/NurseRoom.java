package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NurseRoom extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button doctor_btn;
    Button nurse_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_room);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        doctor_btn = findViewById(R.id.doctor_btn);
        doctor_btn.setOnClickListener(this);

        nurse_btn = findViewById(R.id.nurse_btn);
        nurse_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

            case R.id.doctor_btn:
                startActivity(new Intent(this, DoctorsDetails.class));
                break;

            case R.id.nurse_btn:
                startActivity(new Intent(this, NurseDetails.class));
                break;
        }
    }
}