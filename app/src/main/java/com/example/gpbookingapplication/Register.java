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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private TextView GPService, Register, login;
    private EditText editTextFullName, editTextAge, editTextPhoneNumber, editTextEmail, editTextPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

       GPService = (TextView) findViewById(R.id.GPService);
        GPService.setOnClickListener(this);

        Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(this);

        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.FullName);
        editTextAge = (EditText) findViewById(R.id.Age);
        editTextPhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        editTextEmail = (EditText) findViewById(R.id.Email);
        editTextPassword = (EditText) findViewById(R.id.Password);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.GPService:
             startActivity(new Intent(this, MainActivity.class));
             break;

         case R.id.Register:
             Register();
             break;


         case  R.id.login:
             startActivity(new Intent(this,MainActivity.class));
             break;
     }
    }

    private void Register() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullName = editTextFullName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextFullName.setError("Full Name is Required!");
            editTextFullName.requestFocus();
            return;
        }

        if(age.isEmpty()){
            editTextAge.setError("Age is Required!");
            editTextAge.requestFocus();
            return;
        }
        if(age.length() > 2){
            editTextAge.setError("Age is Over count");
            editTextAge.requestFocus();
            return;
        }

        if(phoneNumber.isEmpty()){
            editTextPhoneNumber.setError("Phone Number is Required!");
            editTextPhoneNumber.requestFocus();
            return;
        }
        if(!Patterns.PHONE.matcher(phoneNumber).matches()){
            editTextPhoneNumber.setError("Please Provide Valid Phone Number!");
            editTextPhoneNumber.requestFocus();
            return;
        }

        if(phoneNumber.length() < 11 ){
            editTextPhoneNumber.setError("Valid Phone Number Required!");
            editTextPhoneNumber.requestFocus();
            return;
        }
        if(phoneNumber.length() > 11 ){
            editTextPhoneNumber.setError("Valid Phone Number Required!");
            editTextPhoneNumber.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("Email is Required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please Provide Valid Email!");
            editTextEmail.requestFocus();
            return;

        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is Required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Minimum 6 characters Required!");
            editTextPassword.requestFocus();
            return;
        }

        // progress bar //
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task. isSuccessful()){
                            User user = new User(fullName, age, email, phoneNumber);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                        if (user.isEmailVerified()) {
                                            //redirect to user profile
                                            startActivity(new Intent(Register.this, ProfileActivity.class));
                                        } else {
                                            user.sendEmailVerification();
                                            Toast.makeText(Register.this, "Entered Details has been Received Successfully!", Toast.LENGTH_LONG).show();
                                        }


                                    }



                                    if (task.isSuccessful()){
                                       Toast.makeText(Register.this,"Check and Verify Your Email Please!", Toast.LENGTH_LONG).show();
                                       progressBar.setVisibility(View.GONE);
                                       // redirect to Login Layout!
                                    }else{
                                        Toast.makeText(Register.this,"Register is Failed, Please Try Again!!",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }

                            });
                        }else {
                            Toast.makeText(Register.this,"This User Already Registered! Please Login.",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
    }
}