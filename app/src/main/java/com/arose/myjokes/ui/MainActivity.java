package com.arose.myjokes.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.arose.myjokes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.jokeButton) Button mJokeButton;

    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mJokeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, JokesListActivity.class);
            startActivity(intent);
        }
    }
