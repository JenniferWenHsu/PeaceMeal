package com.example.eecs.peacemeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        final Button completeButton = (Button) findViewById(R.id.completeButton);
        completeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                sendMessage(v);
            }
        });

        /**
         * This is hackathon style. Time constraint results in nonDRY code
         */
        //Meat List View
        ListView listview = (ListView)findViewById(R.id.listView);
        //string array
        String[] foody = {"fish", "beef", "chicken"};
        // set adapter for listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, foody);
        listview.setAdapter(adapter);
        listview.setItemsCanFocus(false);
        // we want multiple clicks
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //select all items first
        for ( int i=0; i< adapter.getCount(); i++ ) {
            listview.setItemChecked(i, true);
        }
        final Button unselectMeatButton = (Button) findViewById(R.id.meatUnselectAll);
        unselectMeatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListView listview = (ListView)findViewById(R.id.listView);
                String[] meat = {"fish", "beef", "chicken"};
                int count = 0;
                for(int i = 0; i<meat.length;i++) {
                    if(listview.isItemChecked(i)) {
                        count++;
                    }
                }
                //if all are selected
                if(count == meat.length){
                    for(int i=0;i<meat.length;i++) {
                        listview.setItemChecked(i, false);
                    }
                    unselectMeatButton.setText("Select All Meat");
                }
                //if none are selected
                else{
                    for(int i=0;i<meat.length;i++) {
                        listview.setItemChecked(i, true);
                    }
                    unselectMeatButton.setText("Unselect All Meat");
                }

            }
        });

        //Diary List View
        ListView listview2 = (ListView)findViewById(R.id.listView2);
        //string array
        String[] diary = {"milk", "egg"};
        // set adapter for listview
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.list_item, diary);
        listview2.setAdapter(adapter2);
        listview2.setItemsCanFocus(false);
        // we want multiple clicks
        listview2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //select all items first
        for ( int i=0; i< adapter2.getCount(); i++ ) {
            listview2.setItemChecked(i, true);
        }
        final Button unselectDiaryButton = (Button) findViewById(R.id.diaryUnselectAll);
        unselectDiaryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListView listview2 = (ListView)findViewById(R.id.listView2);
                String[] diary = {"milk", "egg"};
                int count = 0;
                for(int i = 0; i<diary.length;i++) {
                    if(listview2.isItemChecked(i)) {
                        count++;
                    }
                }
                //if all are selected
                if(count == diary.length){
                    for(int i=0;i<diary.length;i++) {
                        listview2.setItemChecked(i, false);
                    }
                    unselectDiaryButton.setText("Select All Diary");
                }
                //if none are selected
                else{
                    for(int i=0;i<diary.length;i++) {
                        listview2.setItemChecked(i, true);
                    }
                    unselectDiaryButton.setText("Unselect All Diary");
                }

            }
        });
        //create the imageButton and it changes picture onClick, store information in the filter array
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DishFeedActivity.class);
        startActivity(intent);
    }
}
