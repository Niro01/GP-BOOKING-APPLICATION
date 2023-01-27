package com.example.gpbookingapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Prescription_Confirmation extends AppCompatActivity {

    TextView listView;
    String list_choices;

    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription__confirmation);


        listView = (TextView) findViewById(R.id.listView);


        //getting the passed value from MainActivity
        Bundle bundle = getIntent().getExtras();
        list_choices = bundle.getString("choices");


        listView.setText(list_choices);

        mainLayout = (LinearLayout) findViewById(R.id.main_Layout);

    }


    public void buttonClick(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Confirmation");
        alertDialogBuilder.setIcon(R.drawable.ic_done);
        alertDialogBuilder.setMessage("Your Prescription Request has been Sent.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Prescription_Confirmation.this, ProfileActivity.class));
            }
        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }


    public void buttonCancel(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert....!!");
        alertDialogBuilder.setIcon(R.drawable.ic_alert);
        alertDialogBuilder.setMessage("Are you sure !! Do You Want to Cancel this Prescription Order ?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Prescription_Confirmation.this, ProfileActivity.class));
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Prescription_Confirmation.this, "Request Opt",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }
}
