package com.example.eecs.peacemeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodFiltersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_filters);

        final RadioButton category_meat = (RadioButton) findViewById(R.id.radioButton_meat);
        final RadioButton category_dairy = (RadioButton) findViewById(R.id.radioButton_dairy);

        HashMap<String, String> map = new HashMap<RadioButton, List<Button> >();

        Button food_buttons[] = new Button[5];
        LinearLayout layout = (LinearLayout) findViewById(R.id.newlayout);
        for(int index = 0; index < 5; index++){
            food_buttons[index] = new Button(this);
            food_buttons[index].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            food_buttons[index].setText("Button # " + index);//null ptr exception error
            layout.addView(food_buttons[index]);
        }
    }

}
