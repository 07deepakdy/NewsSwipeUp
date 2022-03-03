package com.example.servicestutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent serviceIntent=new Intent(this,ForegroundService.class);
       if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
       {
           startForegroundService(serviceIntent);
       }else
       {
           startService(serviceIntent);
       }


    }

}