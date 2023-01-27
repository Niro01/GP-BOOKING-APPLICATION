package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gpbookingapplication.models.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookGP extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    Button Dr_Halan, Dr_Lee, Dr_Balia, Dr_Raj, Dr_Kamila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_g_p);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView UserNameTextView = (TextView) findViewById(R.id.UserName);

        Dr_Halan = (Button) findViewById(R.id.Dr_Halan);
        Dr_Halan.setOnClickListener(this);

        Dr_Lee = (Button) findViewById(R.id.Dr_Lee);
        Dr_Lee.setOnClickListener(this);

        Dr_Balia = (Button) findViewById(R.id.Dr_Balia);
        Dr_Balia.setOnClickListener(this);

        Dr_Raj = (Button) findViewById(R.id.Dr_Raj);
        Dr_Raj.setOnClickListener(this);

        Dr_Kamila = (Button) findViewById(R.id.Dr_Kamila);
        Dr_Kamila.setOnClickListener(this);



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

                case R.id.Dr_Halan:
                startActivity(new Intent(this, Dr_Halan_Adward.class));
                break;

                case R.id.Dr_Lee:
                startActivity(new Intent(this, Dr_Lee_Tran.class));
                break;

                case R.id.Dr_Balia:
                startActivity(new Intent(this, Dr_Balai_Maha.class));
                break;

                case R.id.Dr_Raj:
                startActivity(new Intent(this, Dr_Raj_Malinga.class));
                break;

                case R.id.Dr_Kamila:
                startActivity(new Intent(this, Dr_Kamila_Ahmed.class));
                break;


        }
    }
}