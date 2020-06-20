package com.daniel.notify

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }

    fun notifyButton(view: View){
        var builder = NotificationCompat.Builder(this, "1")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Test")
            .setContentText("Message")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setAutoCancel(true)


        val name = "Main"
        val descriptionText = "All your alerts"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("1", name, importance).apply {
            description = descriptionText
        }

        // Register the channel with the system
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)


        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }



    }


}