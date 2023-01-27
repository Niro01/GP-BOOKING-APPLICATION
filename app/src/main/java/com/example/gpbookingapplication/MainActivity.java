package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import com.example.gpbookingapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Initialize variable
    WebView webView;

    private TextView newRegister, forgotPassword;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private Intent HomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HomeActivity = new Intent(this,com.example.gpbookingapplication.ProfileActivity.class);

        newRegister = (TextView) findViewById(R.id.newRegister);
        newRegister.setOnClickListener(this);

        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.Email);
        editTextPassword = (EditText) findViewById(R.id.Password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        mAuth = FirebaseAuth.getInstance();

        forgotPassword = (TextView) findViewById(R.id.ForgotPassword);
        forgotPassword.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.newRegister:
             startActivity(new Intent(this, Register.class));
             break;

         case R.id.signIn:
             signIn();
             break;

         case R.id.ForgotPassword:
             startActivity(new Intent(this, ForgotPassword.class));
             break;
     }
    }

    private void signIn() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

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

        if (password.isEmpty()){
            editTextPassword.setError("Password is Required!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextPassword.setError("Minimum 6 characters Required!");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()) {
                        //redirect to user profile
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this,"Check and Verify Your Email Please!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                }else {
                    Toast.makeText(MainActivity.this,"Signin is Failed! Please Check Your Validation.", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        //Assign variable
        webView = findViewById(R.id.web_view);


        //Initialize webSetting
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Initialize connectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        //Get active network info
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        //Check network status
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()){
            //When internet is inactive
            Toast.makeText(MainActivity.this,"Signin is Failed! Please Check Your Internet Connection.", Toast.LENGTH_LONG).show();
            //Initialize dialog
            Dialog dialog = new Dialog(this);
            //Set Content view
            dialog.setContentView(R.layout.alert_dialog);
            //Set outside touch
            dialog.setCanceledOnTouchOutside(false);
            //Dialog width and height
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            //Set transparent background
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //Set animation
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;

            //Initialize dialog variable
            Button btnTryAgain = dialog.findViewById(R.id.btn_try_again);
            //Perform onClick listener
            btnTryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Call  recreate method
                    recreate();
                }
            });

            //Show dialog
            dialog.show();
        }else {
        //When internet is active

            //Load url in webView
            webView.loadUrl("com.example.gpbookingapp");

    }

    }
}