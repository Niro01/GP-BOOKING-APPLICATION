package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RateUs extends AppCompatActivity implements View.OnClickListener {
    Button Submit_btn;
    ImageView home_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);


        Submit_btn = (Button)findViewById(R.id.Submit_btn);
        Submit_btn.setOnClickListener(this);

        home_btn = (ImageView) findViewById(R.id.home_btn);
        home_btn.setOnClickListener(this);

        final RatingBar ratingRatingBar = (RatingBar)findViewById(R.id.ratingBar2);
         final TextView ratingDisplayTextView = (TextView)findViewById(R.id.Rating_display);

        Submit_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ratingDisplayTextView.setText("Your Rating is: " + ratingRatingBar.getRating());
                Toast.makeText(RateUs.this,"Thank you for your Rating and Click Home Button.", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.home_btn:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }
}