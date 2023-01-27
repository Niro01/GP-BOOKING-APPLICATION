package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class logout extends AppCompatActivity implements View.OnClickListener {
    private Button Yes, No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        Yes = (Button) findViewById(R.id.Yes);
        Yes.setOnClickListener(this);

        No = (Button) findViewById(R.id.No);
        No.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Yes:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.No:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }


    }
}