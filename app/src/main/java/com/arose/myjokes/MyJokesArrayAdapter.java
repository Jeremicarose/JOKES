package com.arose.myjokes;


import android.content.Context;
import android.widget.ArrayAdapter;

public class MyJokesArrayAdapter extends ArrayAdapter {
    private Context mContext;


    public MyJokesArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;

    }

    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];

        return String.format("%s \nServes great: %s", restaurant, cuisine);
    }

    @Override
    public  int getCount() {
        return mRestaurants.length;
    }
}


public class MyJokesArrayAdapter {
}
