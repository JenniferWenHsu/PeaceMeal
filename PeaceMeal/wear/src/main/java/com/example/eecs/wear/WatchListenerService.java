package com.example.eecs.wear;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 * Created by Jennifer Hsu on 4/20/16.
 */
public class WatchListenerService extends WearableListenerService {

    //   WearableListenerServices don't need an iBinder or an onStartCommand: they just need an onMessageReceieved.
    private String TAG = "PeaceMeal";
    private static final String DISH_PATH = "/Dish";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d(TAG, "in PhoneListenerService, got: " + messageEvent.getPath());
        if( messageEvent.getPath().equalsIgnoreCase(DISH_PATH) ) {
            String dishText = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Log.d(TAG, "WatchListenerService onMessageReceived dish text: "+dishText);
            Log.d(TAG, "Launching MainActivity");
            Intent intent = new Intent(this, Main2Activity.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("DISH",dishText);
            startActivity(intent);

        }
        else {
            Log.d(TAG, "Failure!");
        }

    }
}