package com.example.eecs.peacemeal;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by chonyi on 4/19/16.
 */
class MyOnClickListener implements View.OnClickListener
{
    private final int position;
    private Context mContext;
    private Button btn;


    public MyOnClickListener(int position, Button b)
    {
        this.position = position;
        btn = b;
    }

    public void onClick(View v)
    {
        // Preform a function based on the position
        //Intent intent = new Intent(mContext, SelectionActivity.class);
        //mContext.startActivity(intent);
        btn.setText("X");

    }


}