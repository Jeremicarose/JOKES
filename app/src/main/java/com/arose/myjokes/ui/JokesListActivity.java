package com.arose.myjokes.ui;


import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arose.myjokes.Constants;
import com.arose.myjokes.R;
import com.arose.myjokes.models.JokesResponse;
import com.arose.myjokes.models.Value;
import com.arose.myjokes.services.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokesListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_list_item);
        final ListView listView = findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder( )
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create( ))
                .build( );

        Api api = retrofit.create(Api.class);
        Call<JokesResponse> call = api.getJokes();
        call.enqueue(new Callback<JokesResponse>( ) {
            @Override
            public void onResponse(Call<JokesResponse> call, Response<JokesResponse> response) {
                List<Value> jokes = response.body().getValue();
                String[] jokesList = new String[jokes.size()];

                for (int i = 0; i < jokes.size( ); i++) {
                    jokesList[i] = jokes.get(i).getJoke();
                }

                listView.setAdapter(
                        new ArrayAdapter<String>(
                                JokesListActivity.this,
                                android.R.layout.simple_list_item_1,
                                jokesList

                        )
                );
            }

            @Override
            public void onFailure(Call<JokesResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext( ), t.getMessage( ), Toast.LENGTH_SHORT).show( );
            }
        });
    }
}

