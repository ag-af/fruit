package com.northcoders.fruit_app.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.fruit_app.service.ApiService;
import com.northcoders.fruit_app.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitRepository {

    private List<Fruit> fruits = new ArrayList<>();
    private MutableLiveData<List<Fruit>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public FruitRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Fruit>> getMutableLiveData() {
        ApiService apiService = RetrofitInstance.getService();
        Call<List<Fruit>> call = apiService.getAllFruits();

        call.enqueue(new Callback<List<Fruit>>() {

            @Override
            public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
                if (response.isSuccessful()) {
                   fruits = response.body();
                   mutableLiveData.setValue(fruits);
                }
            }

            @Override
            public void onFailure(Call<List<Fruit>> call, Throwable throwable) {
                Log.i("HTTP error", throwable.getMessage());
            }
        });
        return mutableLiveData;
    }
}
