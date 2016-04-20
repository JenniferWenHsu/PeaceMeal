package com.example.eecs.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private static final String TAG = "PeaceMeal";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView = (EditText) findViewById(R.id.text);

        Log.d(TAG, "Watch Main2Activity received information");
        //Receive update from phone (dish)
        // Toast.makeText(Main2Activity.this, "Received " + zipCode, Toast.LENGTH_LONG).show();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String dishtext = extras.getString("DISH");
            mTextView.setText(dishtext);
        }
    }
}