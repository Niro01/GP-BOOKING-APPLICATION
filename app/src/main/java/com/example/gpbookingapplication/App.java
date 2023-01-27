package com.example.gpbookingapplication;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CONFIRMATION_ID = "CONFIRMATION";

    @Override
    public void onCreate() {
        super.onCreate();

        createConfirmationNotification();
    }

    private void createConfirmationNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel ConfirmationNotification = new NotificationChannel(
                    CONFIRMATION_ID,
                    "CONFIRMATION",
                    NotificationManager.IMPORTANCE_HIGH
            );
            ConfirmationNotification.setDescription("Your Appointment Time has been Booked");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(ConfirmationNotification);
        }
    }
}
