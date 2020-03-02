package com.vsm.timemanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Notification
        createNotificationChannel()
//         Apply the layouts to the notification
        val customNotification = NotificationCompat.Builder(this, getString(R.string.channel_id))
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle("App was turned on")
            .setContentText("This is first time application was turned on.\nAnd of course it was cosed")
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            //                .setCustomContentView(notificationLayout)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1, customNotification)

        Log.d("Test", "Worked")
        finish()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(getString(R.string.channel_id), name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager =
                getSystemService<NotificationManager>(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }
}