package com.example.eecs.peacemeal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class DishFeedActivity extends Activity {
    private static final String TAG = "PeaceMeal";
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "DishFeedActivity onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listView = (ListView) findViewById(R.id.card_listView);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);

        for (int i = 0; i < 10; i++) {
            Card card = new Card(R.drawable.fish, "Card " + (i+1) + " Line 2");
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);

        //send intent to watch
        Log.d(TAG, "DishFeedActivity attempting to send DISH to PhoneToWatchService");
        Intent sendToWatchIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        sendToWatchIntent.putExtra("DISH", "Dish1");
        startService(sendToWatchIntent);

    }
}
