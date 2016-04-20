package com.example.eecs.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private static final String TAG = "PeaceMeal";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });

        Log.d(TAG, "Watch Main2Activity received information");
        //Receive update from phone (dish)
        Intent intent = getIntent();
        String zipCode = intent.getStringExtra("DISH");
        Toast.makeText(Main2Activity.this, "Received " + zipCode, Toast.LENGTH_LONG).show();
    }
}
