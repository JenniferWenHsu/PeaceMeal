package com.example.eecs.peacemeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodFiltersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_layout);

        // In your oncreate (or where ever you want to create your gridview)
        GridView gridview = (GridView) findViewById(R.id.gridview);
        ButtonAdapter btn_adapter = new ButtonAdapter(this);
        gridview.setAdapter(btn_adapter);

        final Button completeButton = (Button) findViewById(R.id.button_complete);

        completeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                sendMessage(v);
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DishFeedActivity.class);
        startActivity(intent);
    }
}
