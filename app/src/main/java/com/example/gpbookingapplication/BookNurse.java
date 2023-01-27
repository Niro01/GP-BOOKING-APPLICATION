package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gpbookingapplication.nurses.Nurse_Miss_Lena_Anroosh;
import com.example.gpbookingapplication.nurses.Nurse_Mr_Ellie_Tran;
import com.example.gpbookingapplication.nurses.Nurse_Mr_Jaxon_Bell;
import com.example.gpbookingapplication.nurses.Nurse_Mrs_Madison_Julian;
import com.example.gpbookingapplication.nurses.Nurse_Mrs_Vithya_Kumar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookNurse extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    Button nurse_Mr_Jaxon, nurse_Mr_Ellie, nurse_Mrs_Madison, nurse_Miss_Lena, nurse_Mrs_Vithya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_nurse);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        nurse_Mr_Jaxon = (Button) findViewById(R.id.nurse_Mr_Jaxon);
        nurse_Mr_Jaxon.setOnClickListener(this);

        nurse_Mr_Ellie = (Button) findViewById(R.id.nurse_Mr_Ellie);
        nurse_Mr_Ellie.setOnClickListener(this);

        nurse_Mrs_Madison = (Button) findViewById(R.id.nurse_Mrs_Madison);
        nurse_Mrs_Madison.setOnClickListener(this);

        nurse_Miss_Lena = (Button) findViewById(R.id.nurse_Miss_Lena);
        nurse_Miss_Lena.setOnClickListener(this);

        nurse_Mrs_Vithya = (Button) findViewById(R.id.nurse_Mrs_Vithya);
        nurse_Mrs_Vithya.setOnClickListener(this);

        //Data base UserName
        final TextView UserNameTextView = (TextView) findViewById(R.id.UserName);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String fullName = userProfile.fullName;

                    UserNameTextView.setText(fullName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

            case R.id.nurse_Mr_Jaxon:
                startActivity(new Intent(this, Nurse_Mr_Jaxon_Bell.class));
                break;

            case R.id.nurse_Mr_Ellie:
                startActivity(new Intent(this, Nurse_Mr_Ellie_Tran.class));
                break;

            case R.id.nurse_Mrs_Madison:
                startActivity(new Intent(this, Nurse_Mrs_Madison_Julian.class));
                break;

            case R.id.nurse_Miss_Lena:
                startActivity(new Intent(this, Nurse_Miss_Lena_Anroosh.class));
                break;

            case R.id.nurse_Mrs_Vithya:
                startActivity(new Intent(this, Nurse_Mrs_Vithya_Kumar.class));
                break;

        }
    }
}