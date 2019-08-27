package com.arose.myjokes;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] jokes = new String[] {"I've never actually been caught smoking weed.\n" +
            "But I'm pretty sure my parents know sober people don't give goodnight handshakes.", "Why did Jeffery Dahmer have a blender on his front porch?\n" +
            "So he could greet you with a handshake.", "How do two lawyers greet each other?\n" +
            "With a firm handshake.", "What do cannibals and politicians have in common?\n" +
            "They both enjoy handshakes.", "A woman gets on a bus with her baby. The driver says: \"Ugh, that's the ugliest baby I've ever seen.\"\n" +
            "\n" +
            "The woman walks to the rear of the bus and sits down, fuming. She says to the man next to her: \"The driver just insulted me.\"\n" +
            "\n" +
            "The man says: \"You go up there and tell him off. Go on, I'll hold your monkey for you.\"\n" +
            "The teacher said to his class one day, \"Please stand up, anyone who thinks they're stupid.\"\n" +
            "\n" +
            "Nobody stood up so the teacher said, \"I'm sure there are some stupid students in this class!\"\n" +
            "\n" +
            "At this point Little Johnny stood up.\n" +
            "\n" +
            "The teacher said, \"Oh Johnny! So you think you're stupid then?\"\n" +
            "\n" +
            "Little Johnny replied, \"No, I just felt bad that you were standing up on your own.\"" };
    private String[] cuisines = new String[] {"jokes", };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, jokes);
        MyJokesArrayAdapter adapter1= new MyJokesArrayAdapter(this, android.R.layout.simple_list_item_1, jokes, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(JokesActivity.this, restaurant, Toast.LENGTH_LONG).show();

            }
        });


    }
}

