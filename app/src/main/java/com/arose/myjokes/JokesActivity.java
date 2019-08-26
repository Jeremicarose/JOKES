package com.arose.myjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokesActivity extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;

    private String[] jokes = new String[] {"I've never actually been caught smoking weed.\n" +
            "But I'm pretty sure my parents know sober people don't give goodnight handshakes.", "Why did Jeffery Dahmer have a blender on his front porch?\n" +
            "So he could greet you with a handshake.", "How do two lawyers greet each other?\n" +
            "With a firm handshake.", "What do cannibals and politicians have in common?\n" +
            "They both enjoy handshakes." };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, jokes);
        MyJokesArrayAdapter adapter1= new MyJokesArrayAdapter(this, android.R.layout.simple_list_item_1, jokes,);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String joke = ((TextView)view).getText().toString();
                Toast.makeText(JokesActivity.this, joke, Toast.LENGTH_LONG).show();

            }
        });




    }
}
