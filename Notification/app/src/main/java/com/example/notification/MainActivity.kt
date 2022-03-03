package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.LightingColorFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID="channel_id"
    val CHANNEL_NAME="channel"
    val NOTIFICATION_ID=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        createNotificationChannel()

        val intent =Intent(this,MainActivity::class.java)
        val pendingIntent= TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }


        val notification= NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_message_24)
            .setContentTitle("Testing")
            .setContentText("This is testing for notification ")
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT )
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager=NotificationManagerCompat.from(this)
       button_show.setOnClickListener {
           notificationManager.notify(NOTIFICATION_ID,notification)
       }

    }
    fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O)
        {
            val channel=NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor= Color.GREEN
                enableLights(true)

            }
            // Register the channel with the system
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}