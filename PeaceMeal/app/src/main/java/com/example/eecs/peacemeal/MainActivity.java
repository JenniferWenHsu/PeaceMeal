package com.example.eecs.peacemeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button facebookButton = (Button) findViewById(R.id.facebookLogin);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                sendMessage(v);
            }
        });


    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
    }

}
