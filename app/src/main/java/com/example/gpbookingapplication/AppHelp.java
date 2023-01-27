package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AppHelp extends AppCompatActivity  implements View.OnClickListener {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_help);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }

    public void ClickClickhere(View view) {
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aK8VHzyXmF0/"));
        startActivity(broswerIntent);
    }

    public void ClickDrawerClickhere(View view) {
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BYLrgUHBI34"));
        startActivity(broswerIntent);
    }

    public void ClickBookingGP(View view) {
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1tCD98V0-JQ"));
        startActivity(broswerIntent);
    }

    public void ClickPrescrition(View view) {
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Knf3MzCEmpA"));
        startActivity(broswerIntent);
    }

    public void ClickOrder(View view) {
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=PQv0-vZ1nbU"));
        startActivity(broswerIntent);
    }

    public void ClickRate(View view) {
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aN61_M-16I0"));
        startActivity(broswerIntent);
    }
}