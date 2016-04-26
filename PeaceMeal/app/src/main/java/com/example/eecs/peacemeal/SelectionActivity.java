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
                String[] foody = {"fish", "beef", "chicken"};
                int count = 0;
                for(int i = 0; i<foody.length;i++) {
                    if(listview.isItemChecked(i)) {
                        count++;
                    }
                }
                //if all are selected
                if(count == foody.length){
                    for(int i=0;i<foody.length;i++) {
                        listview.setItemChecked(i, false);
                    }
                    unselectMeatButton.setText("Select All Meat");
                }
                //if none are selected
                else{
                    for(int i=0;i<foody.length;i++) {
                        listview.setItemChecked(i, true);
                    }
                    unselectMeatButton.setText("Unselect All Meat");
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
