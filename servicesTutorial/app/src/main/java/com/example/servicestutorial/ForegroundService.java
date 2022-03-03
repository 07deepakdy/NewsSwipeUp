package com.example.servicestutorial;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service {



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();
        Intent intent1=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent1,0);
        Notification notification=new NotificationCompat.Builder(this,"ChannelID")
                .setContentTitle("My app Tutorial")
                .setContentText("Our Application is Running")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    Log.e("service", "Service is Running  ");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.getStackTrace();
                    }
                }
            }
        }).start();

        return START_STICKY;
    }
    public void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            NotificationChannel channel= null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel = new NotificationChannel(
                        "ChannelID",
                        "ChannelName",
                        NotificationManager.IMPORTANCE_DEFAULT
                );
            }
            NotificationManager manager=getSystemService(NotificationManager.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        stopForeground(true);
        stopSelf();
        super.onDestroy();
    }
}
