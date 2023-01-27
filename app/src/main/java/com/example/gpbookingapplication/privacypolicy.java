package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class privacypolicy extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacypolicy);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

    }
    public void broswer1(View View){
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gov.uk/government/publications/nhs-covid-19-app-privacy-information"));
        startActivity(broswerIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }
}