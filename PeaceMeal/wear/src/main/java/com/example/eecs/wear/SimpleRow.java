package com.example.eecs.wear;

import java.util.ArrayList;

/**
 * Created by apple on 4/20/16.
 */
public class SimpleRow {

    ArrayList<SimplePage> mPagesRow = new ArrayList<SimplePage>();

    public void addPages(SimplePage page) {
        mPagesRow.add(page);
    }

    public SimplePage getPages(int index) {
        return mPagesRow.get(index);
    }

    public int size(){
        return mPagesRow.size();
    }
}