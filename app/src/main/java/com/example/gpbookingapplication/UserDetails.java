package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDetails extends AppCompatActivity implements View.OnClickListener {

    private FirebaseUser user;
    private DatabaseReference reference;
    ImageView imageView;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);


        final TextView fullNameTextView = (TextView) findViewById(R.id.FullName2);
        final TextView ageTextView = (TextView) findViewById(R.id.Age2);
        final TextView phoneNumberTextView = (TextView) findViewById(R.id.PhoneNumber2);
        final TextView emailAddressTextView = (TextView) findViewById(R.id.EmailAddress2);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null){
                    String fullName = userProfile.fullName;
                    String age = userProfile.age;
                    String phoneNumber = userProfile.phoneNumber;
                    String emailAddress = userProfile.email;

                    fullNameTextView.setText(fullName);
                    ageTextView.setText(age);
                    phoneNumberTextView.setText(phoneNumber);
                    emailAddressTextView.setText(emailAddress);

                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserDetails.this,"Something Wrong Happened!",Toast.LENGTH_SHORT).show();

            }


        });




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
    }
}}