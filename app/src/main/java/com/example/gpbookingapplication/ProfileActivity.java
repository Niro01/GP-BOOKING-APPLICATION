package com.example.gpbookingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gpbookingapplication.Pharmacy;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    FirebaseAuth mAuth;
    FirebaseUser currentUser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView UserNameTextView = (TextView) findViewById(R.id.UserName);
        final TextView UserEmailTextView = (TextView) findViewById(R.id.UserEmail1);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null){
                    String fullName = userProfile.fullName;
                    String emailAddress = userProfile.email;

                    UserNameTextView.setText(fullName);
                    UserEmailTextView.setText(emailAddress);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view) {
        //OpenDrawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        //Recreate activity
        recreate();
    }

    public void ClickAccount(View view) {
        //Redirect activity to Account
        redirectActivity(this, UserDetails.class);
    }
    public void ClickHistory(View view) {
        //Redirect activity to Account
        redirectActivity(this, History.class);
    }
    public void ClickPhone(View view) {
        //Redirect activity to Account
        redirectActivity(this, Phone.class);
    }
    public void ClickChat(View view) {
        //Redirect activity to Account
        redirectActivity(this, Chat.class);
    }

    public void ClickRateus(View view) {
        //Redirect activity to Account
        redirectActivity(this, RateUs.class);
    }

    public void ClickLogout(View view) {
        //Redirect activity to Account
        redirectActivity(this, logout.class);


        //Home Page Icons
    }
    public void ClickBook(View view) {
        //Redirect activity to Book GP
        redirectActivity(this, Book_GP_Splash.class);
    }
    public void ClickNurse(View view) {
        //Redirect activity to Book Nurse
        redirectActivity(this, BookNurse.class);
    }
    public void ClickSpecialist(View view) {
        //Redirect activity to Book Specialist
        redirectActivity(this, BookSpecialist.class);
    }
    public void ClickPrescription(View view) {
        //Redirect activity to Prescription
        redirectActivity(this, Prescription.class);
    }
    public void ClickCorona(View view) {
        //Redirect activity to Corona
        redirectActivity(this, Corona.class);
    }
    public void ClickSelf_Iso(View view) {
        //Redirect activity to self isolation
        redirectActivity(this, Self_Isolation.class);
    }
    public void ClickRoom(View view) {
        //Redirect activity to NurseRoom
        redirectActivity(this, NurseRoom.class);
    }
    public void Clickpharmacy(View view) {
        //Redirect activity to Pharmacy
        redirectActivity(this, Pharmacy.class);
    }
    public void ClickSpecialistRoom(View view) {
        //Redirect activity to SpecialistRoom
        redirectActivity(this, SpecialistRoom.class);
    }
    public void ClickAppHelp(View view) {
        //Redirect activity to AppHelp
        redirectActivity(this, AppHelp.class);
    }


    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity, aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
    public void ClickInstagram(View View){
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
        startActivity(broswerIntent);
    }
    public void ClickYoutube(View View){
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC8ew0Sl5DmKI-cZBk16yGow/videos"));
        startActivity(broswerIntent);
    }
    public void ClickTwitter(View View){
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Twitter?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
        startActivity(broswerIntent);
    }
    public void ClickFacebook(View View){
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
        startActivity(broswerIntent);
    }

    //COVID-19 Guidance
    public void Clickprotection_against_COVID_19(View View){
        Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public"));
        startActivity(broswerIntent);
    }

}