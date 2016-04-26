package com.example.eecs.peacemeal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class checkbox extends CheckBox {



    public checkbox(Context context, AttributeSet attrs) {
        super(context, attrs);
        //setButtonDrawable(new StateListDrawable());
    }
    @Override
    public void setChecked(boolean t){
        if(t)
        {
            this.setBackgroundResource(R.drawable.select);
        }
        else
        {
            this.setBackgroundResource(R.drawable.deselect);
        }
        super.setChecked(t);
    }
}