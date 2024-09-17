package com.northcoders.fruit_app.service;

import com.northcoders.fruit_app.model.Fruit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("all")
    Call<List<Fruit>> getAllFruits();
}
