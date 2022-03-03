package com.example.servicestutorial;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyBackgroundServices extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(
                new Runnable() {
            @Override
            public void run() {
                while(true){
                    Log.e("service", "Service i running... ");
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e)
                    {
                        e.getStackTrace();
                    }
                }

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
