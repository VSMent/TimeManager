package com.vsm.timemanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Service
//        startService();   // Start service and notification

//        Notification
        createNotificationChannel();


        // Get the layouts to use in the custom notification
//        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_small);
//        notificationLayout.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
//        notificationLayout.setTextViewText(R.id.title, "Custom notification");
//        notificationLayout.setTextViewText(R.id.text, "This is a custom layout");



// Apply the layouts to the notification
        Notification customNotification = new NotificationCompat.Builder(this, getString(R.string.channel_id))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("App was turned on")
                .setContentText("This is first time application was turned on.\nAnd of course it was cosed")
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
//                .setCustomContentView(notificationLayout)
                .build();




//        Notification myNotification = new NotificationCompat.Builder(this, getString(R.string.channel_id))
//                .setSmallIcon(R.mipmap.ic_launcher_round)
//                .setContentTitle("App was turned on")
//                .setContentText("This is first time application was turned on.\nAnd of course it was cosed")
////                .setStyle(new NotificationCompat.BigTextStyle()
////                        .bigText("Much longer text that cannot fit one line..."))
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .build();


//        notification.flags |= Notification.FLAG_AUTO_CANCEL;
//        notification.defaults |= Notification.DEFAULT_SOUND;
//        notification.defaults |= Notification.DEFAULT_VIBRATE;
//        notificationManager.notify(1, notification);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, customNotification);

        Log.d("Test", "Worked");
        finish();
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getString(R.string.channel_id), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


        }
    }
}
