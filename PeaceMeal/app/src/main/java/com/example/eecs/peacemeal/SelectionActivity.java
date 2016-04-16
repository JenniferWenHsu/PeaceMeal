package com.example.eecs.peacemeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DishFeedActivity.class);
        startActivity(intent);
    }
}
