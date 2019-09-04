package com.arose.myjokes.models;

import java.util.ArrayList;

public class Joke {
    private String mJoke;
    private String mTitle;
    private double mRating;
    private ArrayList<String> mCategories = new ArrayList<>( );

    public Joke(String joke, String title,
                double rating, ArrayList<String> categories) {
        this.mJoke = joke;
        this.mTitle = title;
        this.mRating = rating;
        this.mCategories = categories;
    }

    public String getmJoke() {
        return mJoke;
    }

    public void setmJoke(String mJoke) {
        this.mJoke = mJoke;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public double getmRating() {
        return mRating;
    }

    public void setmRating(double mRating) {
        this.mRating = mRating;
    }

    public ArrayList<String> getmCategories() {
        return mCategories;
    }

    public void setmCategories(ArrayList<String> mCategories) {
        this.mCategories = mCategories;
    }
}
