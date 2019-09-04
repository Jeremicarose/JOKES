package com.arose.myrestaurants.services;

//import android.telecom.Call;

import com.arose.myrestaurants.Constants;
import com.arose.myrestaurants.models.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class BestService {

    public static void findJokes(String location, Callback callback) {


        OkHttpClient client = new OkHttpClient.Builder( )
                .build( );

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BEST_BASE_URL).newBuilder( );
        urlBuilder.addQueryParameter(Constants.BEST_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build( ).toString( );

        Request request = new Request.Builder( )
                .url(url)
                .header("Authorization","Bearer" + Constants.BEST_TOKEN)
                .build( );

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Joke> processResults(Response response) {
        ArrayList<Joke> jokes = new ArrayList<>( );
        try {

            String xmlData = response.body().string();
            JSONObject bestJSON = XML.toJSONObject(xmlData);
            JSONArray jokesJSON = bestJSON.getJSONArray("jokes");

            if (response.isSuccessful( )) {
                for (int i = 0; i < jokesJSON.length( ); i++) {
                    JSONObject jokeJSON = jokesJSON.getJSONObject(i);
                    String title = jokeJSON.getString("title");
                    String jokey = jokeJSON.getString("joke");
                    double rating = jokeJSON.getDouble("rating");
                    ArrayList<String> categories = new ArrayList<>( );
                    JSONArray categoriesJSON = jokeJSON.getJSONArray("categories");
                    for (int y = 0; y < categoriesJSON.length( ); y++) {
                        categories.add(categoriesJSON.getJSONObject(y).getString("title"));
                    }
                    Joke joke = new Joke(title, jokey, rating, categories);
                    jokes.add(joke);
                }
            }
        } catch (IOException e) {
            e.printStackTrace( );
        } catch (JSONException e) {
            e.printStackTrace( );
        }
        return jokes;
    }
}