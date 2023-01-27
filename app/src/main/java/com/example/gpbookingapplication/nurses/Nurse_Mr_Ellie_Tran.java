package com.example.gpbookingapplication.nurses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gpbookingapplication.BookGP;
import com.example.gpbookingapplication.BookNurse;
import com.example.gpbookingapplication.Booking_Confirmation;
import com.example.gpbookingapplication.History;
import com.example.gpbookingapplication.PickerDialog;
import com.example.gpbookingapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.gpbookingapplication.App.CONFIRMATION_ID;

public class Nurse_Mr_Ellie_Tran extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{
    private DatePickerDialog datePickerDialog;
    ImageView imageView;
    ImageView clock;

    //Notification Detail
    private NotificationManagerCompat notificationManager;
    private EditText editTextName;
    private EditText editTextDOB;
    private EditText emailET;
    EditText date_in;
    EditText nurse_Mr_Ellie_Tran;

    ImageView dropDownArrow;

    AutoCompleteTextView AppointmentTime;

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_mr_ellie_tran);


        notificationManager = NotificationManagerCompat.from(this);

        AppointmentTime = findViewById(R.id.timeslot);

        editTextName = findViewById(R.id.nameET);
        editTextDOB = findViewById(R.id.dobET);
        editTextDOB.setInputType(InputType.TYPE_NULL);
        initDatePicker();


        nurse_Mr_Ellie_Tran = findViewById(R.id.nurse_Mr_Ellie_Tran);
        nurse_Mr_Ellie_Tran.setInputType(InputType.TYPE_NULL);

        date_in=findViewById(R.id.date_input);
        date_in.setOnClickListener(this);
        date_in.setInputType(InputType.TYPE_NULL);

        dropDownArrow = findViewById(R.id.dropdown);

        imageView = (ImageView) findViewById(R.id.back);
        imageView.setOnClickListener(this);

        clock = (ImageView) findViewById(R.id.clock);
        clock.setOnClickListener(this);

        emailET = (EditText) findViewById(R.id.emailET);

        AppointmentTime.setInputType(InputType.TYPE_NULL);

        adapter = new ArrayAdapter<>(this
                , android.R.layout.simple_list_item_1, arrayList);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Booking Details");

        final AutoCompleteTextView AppointmentTime= findViewById(R.id.timeslot);
        AppointmentTime.setThreshold(17);

        ArrayAdapter<String> adapter =  new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, times);
        AppointmentTime.setAdapter(adapter);

        dropDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppointmentTime.showDropDown();
            }
        });

    }


    private static final String[] times = new String[]{
            "07:00 - 07:15 AM", "07:30 - 07:45 AM",
            "08:00 - 08:15 AM", "08:30 - 08:45 AM",
            "09:00 - 09:15 AM", "09:30 - 09:45 AM",
            "10:00 - 10:15 AM", "10:30 - 10:45 AM",
            "11:00 - 11:15 AM", "11:30 - 11.45 AM"
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, BookNurse.class));
                break;

            case R.id.date_input:
                PickerDialog pickerDialog = new PickerDialog();
                pickerDialog.show(getSupportFragmentManager(),"Date Picker");
                break;
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar =  Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        int currentMonth = month+1;
        date_in.setText(dayOfMonth+"/"+currentMonth+"/"+year);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void ConfirmationSubmit(View view) {

        String name = editTextName.getText().toString();
        if (name.isEmpty()){
            editTextName.setError("Name is Required !!");
            editTextName.requestFocus();
            return;
        }

        String dob = editTextDOB.getText().toString();
        if (dob.isEmpty()){
            editTextDOB.setError("Date of Birth is Required !!");
            editTextDOB.requestFocus();
            return;
        }

        String email = emailET.getText().toString();
        if (email.isEmpty()){
            emailET.setError("Email is Required !!");
            emailET.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailET.setError("Please Provide Valid Email !!");
            emailET.requestFocus();
            return;
        }

        String date = date_in.getText().toString();
        if (date.isEmpty()){
            date_in.setError("Date of Birth is Required !!");
            date_in.requestFocus();
            return;
        }

        String time = AppointmentTime.getText().toString();
        if (time.isEmpty()){
            AppointmentTime.setError("Choose Your Time !!");
            AppointmentTime.requestFocus();
            return;
        }

        String appointedName = nurse_Mr_Ellie_Tran.getText().toString().trim();
        String userName = editTextName.getText().toString().trim();
        String userDOB = editTextDOB.getText().toString().trim();
        String userEmail = emailET.getText().toString().trim();
        String UserAppointmentDate = date_in.getText().toString().trim();
        String UserAppointmentTime = AppointmentTime.getText().toString().trim();

        String sKey = databaseReference .push().getKey();

        if (sKey != null) {

            databaseReference.child(sKey).child("Appointment With").setValue(appointedName);
            databaseReference.child(sKey).child("Name").setValue(userName);
            databaseReference.child(sKey).child("Date Of Birth").setValue(userDOB);
            databaseReference.child(sKey).child("Email").setValue(userEmail);
            databaseReference.child(sKey).child("Appointment Date").setValue(UserAppointmentDate);
            databaseReference.child(sKey).child("Appointment Time").setValue(UserAppointmentTime);

            nurse_Mr_Ellie_Tran.setText("");
            editTextName.setText("");
            editTextDOB.setText("");
            emailET.setText("");
            date_in.setText("");
            AppointmentTime.setText("");
        }

        startActivity(new Intent(this, Booking_Confirmation.class));

        Intent activityIntent = new Intent(this, History.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, BookGP.class);
        broadcastIntent.putExtra("toastMessage", dob);

        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = new NotificationCompat.Builder(this, CONFIRMATION_ID)
                .setSmallIcon(R.drawable.logo1)
                .setContentTitle(" Hi" +"\n"+ name)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Hello\t" + name +
                                "\n" +"Thank You For Booking Your Appointment With Us. This is a Confirm Notification For your Booking with " +appointedName+ " at 15 Wideway, CR4 1BP." +
                                "\n" +"You Appointment Date is : " + date +
                                "\n"+"This your Appointment Time : " +time+
                                "\n"+"This your Email : " + email +
                                "\n"+"This your Date of Birth : " +dob+ "\n"+
                                "\n"+ "Thank You,"+"\n"+ "GP Booking Team.")
                        .setBigContentTitle("GP Booking Service")
                        .setSummaryText("Booking Confirmation"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManager.notify(1,notification);
    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                editTextDOB.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}