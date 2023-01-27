package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    private TextView GPService;
    private EditText emailEditText;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth auth;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        GPService = (TextView) findViewById(R.id.GPService);
        GPService.setOnClickListener(this);


        emailEditText = (EditText) findViewById(R.id.Email);
        resetPasswordButton = (Button) findViewById(R.id.ForgotPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);

        auth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();

            }
        });
    }
    private void resetPassword(){
           String email = emailEditText.getText().toString().trim();

           if (email.isEmpty()){
               emailEditText.setError("Provide Valid Email!");
               emailEditText.requestFocus();
               return;
           }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please Provide Valid Email!");
            emailEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this,"Check Your Email to Reset Your Password!", Toast.LENGTH_LONG).show();
                    emailEditText.getText().clear();
                    progressBar.setVisibility(View.GONE);

                }else{
                    Toast.makeText(ForgotPassword.this,"Try agin! Something went Wrong!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.GPService:
                startActivity(new Intent(this, MainActivity.class));
                break;}
    }
}