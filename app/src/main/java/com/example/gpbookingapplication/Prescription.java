package com.example.gpbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gpbookingapplication.questions.Covid_19_Q5;

import java.util.Calendar;

public class Prescription extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    EditText editTextDate;
    DatePickerDialog.OnDateSetListener setListener;
    private EditText editTextName, editTextDOB, editTextAddress, editTextPhoneNumber, editTextSickness, editTextNewPrescription, editTextExistingPrescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);


        editTextName = (EditText) findViewById(R.id.Enter_your_name);
        editTextDOB = (EditText) findViewById(R.id.Date_of_Birth);
        editTextAddress = (EditText) findViewById(R.id.prescription_Address);
        editTextPhoneNumber = (EditText) findViewById(R.id.phone_Number);
        editTextSickness = (EditText) findViewById(R.id.sickness);
        editTextNewPrescription = (EditText) findViewById(R.id.new_Prescription);
        editTextExistingPrescription = (EditText) findViewById(R.id.existing_Prescription);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        editTextDate = findViewById(R.id.Date_of_Birth);

        Calendar calendar = Calendar. getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Prescription. this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date =day+"/"+month+"/"+year;
                editTextDate.setText(date);
            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

        }
    }

    public void Confirm(View view) {

        EditText name = (EditText) findViewById(R.id.Enter_your_name);
        String Name = name.getText().toString();
        if(Name.isEmpty()){
            editTextName.setError("Name is Required !");
            editTextName.requestFocus();
            return;
        }

        EditText dob = (EditText) findViewById(R.id.Date_of_Birth);
        String DOB = dob.getText().toString();
        if(DOB.isEmpty()){
            editTextDOB.setError("Date of Birth is Required !");
            editTextDOB.requestFocus();
            return;
        }

        EditText address = (EditText) findViewById(R.id.prescription_Address);
        String Address = address.getText().toString();
        if(Address.isEmpty()){
            editTextAddress.setError("Address is Required !");
            editTextAddress.requestFocus();
            return;
        }

        EditText phone_number = (EditText) findViewById(R.id.phone_Number);
        String Phone_Number = phone_number.getText().toString();
        if(Phone_Number.isEmpty()){
            editTextPhoneNumber.setError("Phone Number is Required !");
            editTextPhoneNumber.requestFocus();
            return;
        }
        if(Phone_Number.length() > 11){
            editTextPhoneNumber.setError("Phone Number is Invalid !");
            editTextPhoneNumber.requestFocus();
            return;
        }
        if(Phone_Number.length() < 11){
            editTextPhoneNumber.setError("Phone Number is Invalid !");
            editTextPhoneNumber.requestFocus();
            return;
        }

        EditText sickness = (EditText) findViewById(R.id.sickness);
        String Sickness = sickness.getText().toString();
        if(Sickness.isEmpty()){
            editTextSickness.setError("Please Explain Your Sickness ");
            editTextSickness.requestFocus();
            return;
        }

        EditText newPrescription = (EditText) findViewById(R.id.new_Prescription);
        String New_Prescription = newPrescription.getText().toString();
        if(New_Prescription.isEmpty()){
            editTextNewPrescription.setError("Please Confirm If new Yes/No !");
            editTextNewPrescription.requestFocus();
            return;
        }
        if(New_Prescription.length() > 3){
            editTextNewPrescription.setError("Yes or No !!!");
            editTextNewPrescription.requestFocus();
            return;
        }
        if(New_Prescription.length() < 2){
            editTextExistingPrescription.setError("Yes or No !!!");
            editTextExistingPrescription.requestFocus();
            return;
        }

        EditText existingPrescription = (EditText) findViewById(R.id.existing_Prescription);
        String Existing_Prescription = existingPrescription.getText().toString();

        if(Existing_Prescription.isEmpty()){
            editTextExistingPrescription.setError("Please Confirm If Existing Yes/No !");
            editTextExistingPrescription.requestFocus();
            return;
        }
        if(Existing_Prescription.length() > 3){
            editTextExistingPrescription.setError("Yes or No !!!");
            editTextExistingPrescription.requestFocus();
            return;
        }
        if(Existing_Prescription.length() < 2){
            editTextExistingPrescription.setError("Yes or No !!!");
            editTextExistingPrescription.requestFocus();
            return;
        }

        Intent i = new Intent(Prescription.this, Prescription_Confirmation.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices", String.valueOf(
                "Name : " + Name + "\n" +
                        "-----------------------------------------------------"+
                        "\n" +"Date of Birth : " + DOB + "\n" +
                        "-----------------------------------------------------"+
                        "\n" +   "Address : " + Address + "\n" +
                        "-----------------------------------------------------"+
                        "\n" +       "Phone Number : " + Phone_Number + "\n" +
                        "-----------------------------------------------------"+
                        "\n" +      "Sickness Explain : " + Sickness + "\n" +
                        "-----------------------------------------------------"+
                        "\n" +      "New Prescription : " + New_Prescription + "\n" +
                        "-----------------------------------------------------"+
                        "\n" +       "Existing Prescription : " + Existing_Prescription));
        i.putExtras(bundle);
        startActivity(i);
    }

}