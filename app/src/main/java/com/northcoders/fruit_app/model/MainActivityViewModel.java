package com.northcoders.fruit_app.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private FruitRepository fruitRepository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.fruitRepository = new FruitRepository(application);
    }

    public LiveData<List<Fruit>> getFruitList() {
        return fruitRepository.getMutableLiveData();
    }
}
