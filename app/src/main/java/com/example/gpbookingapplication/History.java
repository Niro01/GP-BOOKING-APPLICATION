package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class History extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;

    ListView bookingDetails;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        imageView = (ImageView) findViewById(R.id.History_back);
        imageView.setOnClickListener(this);

        bookingDetails = findViewById(R.id.bookinghistory);

        adapter = new ArrayAdapter<>(this
                , android.R.layout.simple_list_item_1, arrayList);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Booking Details");

        getValue();
    }

    private void getValue() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    String appointedName = dataSnapshot.child("Appointment With").getValue(String.class);
                    String name = dataSnapshot.child("Name").getValue(String.class);
                    String dateOfBirth= dataSnapshot.child("Date Of Birth").getValue(String.class);
                    String email= dataSnapshot.child("Email").getValue(String.class);
                    String appointmentDate= dataSnapshot.child("Appointment Date").getValue(String.class);
                    String appointmentTime= dataSnapshot.child("Appointment Time").getValue(String.class);

                    arrayList.add("\n"
                            +"Appointment With : " + appointedName
                            + "\n" + "Name : " + name
                            + "\n" + "DOB : " + dateOfBirth
                            + "\n" + "Email : " + email
                            + "\n" + "Appointment Date : " + appointmentDate
                            + "\n" + "Appointment Time : " + appointmentTime
                            +"\n");
                }
                bookingDetails.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.History_back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }
}