package com.arose.myjokes;


import android.content.Context;
import android.widget.ArrayAdapter;

public class MyJokesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    Private string[] mJokes;


    public MyJokesArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mJokes = mJokes;

    }

    @Override
    public Object getItem(int position) {
        String restaurant = mJokes[position];

        return String.format("%s \nServes great: %s", restaurant, cuisine);
    }

    @Override
    public  int getCount() {
        return mJokes.length;
    }
}



