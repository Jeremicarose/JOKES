package com.arose.myjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.findJokesButton) Button mFindJokesButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindJokesButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        String location = mLocationEditText.getText().toString();
        Intent intent = new Intent(MainActivity.this, JokesActivity.class);
        intent.putExtra("location", location);
        startActivity(intent);
    }
}
