package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gpbookingapplication.specialist.Specialist_Miss_Emily_Elizabeth;
import com.example.gpbookingapplication.specialist.Specialist_Mr_Paul_Robert;
import com.example.gpbookingapplication.specialist.Specialist_Mr_William_Hentry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookSpecialist extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    Button SL_Paul, SL_William, SL_Emily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_specialist);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView UserNameTextView = (TextView) findViewById(R.id.UserName);

        SL_Paul = (Button) findViewById(R.id.SL_Paul);
        SL_Paul.setOnClickListener(this);

        SL_William = (Button) findViewById(R.id.SL_William);
        SL_William.setOnClickListener(this);

        SL_Emily = (Button) findViewById(R.id.SL_Emily);
        SL_Emily.setOnClickListener(this);

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

            case R.id.SL_Paul:
                startActivity(new Intent(this, Specialist_Mr_Paul_Robert.class));
                break;

            case R.id.SL_William:
                startActivity(new Intent(this, Specialist_Mr_William_Hentry.class));
                break;

            case R.id.SL_Emily:
                startActivity(new Intent(this, Specialist_Miss_Emily_Elizabeth.class));
                break;
        }
    }
}