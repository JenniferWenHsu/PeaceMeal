package com.example.eecs.peacemeal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ButtonAdapter extends BaseAdapter {
    public String[] filenames = {
            "File 1",
            "File 2",
            "File 3",
            "File 4",
            "File 5",
            "File 6",
    };

    private Context mContext;

    // Gets the context so it can be used later
    public ButtonAdapter(Context c) {
        mContext = c;
    }

    // Total number of things contained within the adapter
    public int getCount() {

        return filenames.length;
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return null;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position,
                        View convertView, ViewGroup parent) {

        Button btn;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            btn = new Button(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(200,200));
            btn.setPadding(8, 8, 8, 8);
        }
        else {
            btn = (Button) convertView;
        }


        // Set the onclicklistener so that pressing the button fires an event
        // We will need to implement this onclicklistner.
        btn.setOnClickListener(new MyOnClickListener(position, btn));

        return btn;

    }

}


