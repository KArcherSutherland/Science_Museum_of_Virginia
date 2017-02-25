package org.smv.smvguide;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.connection.internal.protocols.Operation;

import org.smv.smvguide.Activities.MainActivity;
import org.smv.smvguide.rest.models.Results;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 2/10/17.
 */
public class SMVGuide extends Application {
    private BeaconManager beaconManager;
    private List<Results> allPosts;

    @Override
    public void onCreate() {
        super.onCreate();
        beaconManager = new BeaconManager(getApplicationContext());
    }

    public void startListening(List<Results> posts){
        allPosts = posts;
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
                showNotification("Hey", "Lookit diiiis", region.getProximityUUID().toString());
            }
            @Override
            public void onExitedRegion(Region region) {
                //showNotification("O boi", "u gon", "B9407F30-F5F8-466E-AFF9-25556B57FE6D");
            }
        });

        for (int i = 0; i < allPosts.size(); i++) {
            final int index = i;
            if (allPosts.get(i).getAcf().getEstimote() != null) {
                final String estimote = allPosts.get(i).getAcf().getEstimote();
                if (!estimote.equals("1")) { //1 is the default value on a post before an estimote is assigned

                    beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
                        @Override
                        public void onServiceReady() {
                            beaconManager.startMonitoring(new Region(
                                    "monitored region",
                                    UUID.fromString(estimote),
                                    5, 5));
                        }
                    });
                }
            }
        }
    }

    public void showNotification(String title, String message, String UUID) {
        Intent notifyIntent = new Intent(this, MainActivity.class);
        notifyIntent.putExtra("UUID", UUID);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[] { notifyIntent }, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.smallersmvlogo)
                .setContentTitle(title)
                .setContentText(message + UUID)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
