package com.arose.myjokes.services;

import com.arose.myjokes.models.JokesResponse;
import com.arose.myjokes.models.RandomJokeResponse;




import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("jokes/")
    Call<JokesResponse> getJokes();

    @GET("jokes/random")
    Call<RandomJokeResponse> getRandomJoke();
}
