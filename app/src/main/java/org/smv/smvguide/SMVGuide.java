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
import org.smv.smvguide.Activities.ScrollingPostActivity;
import org.smv.smvguide.rest.models.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by root on 2/10/17.
 */
public class SMVGuide extends Application {
    private BeaconManager beaconManager;
    private List<Results> allPosts;
    List<Region> regions;

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

        regions = new ArrayList<>();

        for (int i = 0; i < allPosts.size(); i++) {
            if (allPosts.get(i).getAcf().getEstimote() != null) {
                final String estimote = allPosts.get(i).getAcf().getEstimote();
                if (!estimote.equals("1")) { //1 is the default value on a post before an estimote is assigned
                    regions.add(new Region(
                            "monitored region",
                            UUID.fromString(estimote),
                            5, 5));
                }
            }

        }


        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
                @Override
                public void onServiceReady() {
                    for (int i = 0; i < regions.size(); i++) {
                        beaconManager.startMonitoring(regions.get(i));
                    }
                }
        });

    }

    public void showNotification(String title, String message, String UUID) {
        /*final Intent intent;
        intent = new Intent(mContext, ScrollingPostActivity.class);
        intent.putExtra("Content", mPosts.get(getAdapterPosition()).getContent().getRendered());
        intent.putExtra("Title", mPosts.get(getAdapterPosition()).getTitle().getRendered());
        mContext.startActivity(intent);*/

        Results post = null;
        for (Results x: allPosts) {
            if (x.getAcf().getEstimote().toUpperCase().equals(UUID.toUpperCase())) {
                post = x;
            }
        }

        if (post != null) {
            String postTitle = post.getTitle().getRendered();
            String postContent = post.getContent().getRendered();
            Intent notifyIntent = new Intent(this, ScrollingPostActivity.class);
            notifyIntent.putExtra("Content", postContent);
            notifyIntent.putExtra("Title", postTitle);
            notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                    new Intent[]{notifyIntent}, PendingIntent.FLAG_UPDATE_CURRENT);
            Notification notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.smallersmvlogo)
                    .setContentTitle(postTitle)
                    .setContentText("Look!")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .build();
            notification.defaults |= Notification.DEFAULT_SOUND;
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, notification);
        }
    }
}
