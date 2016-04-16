package com.example.eecs.peacemeal;

/**
 * Created by Jennifer Hsu on 4/15/16.
 */
public class Card {
    private int imageId;
    private String line2;

    public Card(int id, String line2) {
        this. imageId= id;
        this.line2 = line2;
    }

    public int getImageId() {
        return imageId;
    }

    public String getLine2() {
        return line2;
    }

}