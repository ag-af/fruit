package com.northcoders.fruit_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.fruit_app.databinding.FruitItemBinding;
import com.northcoders.fruit_app.model.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> fruitList;
    private Context context;

    public FruitAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        private final FruitItemBinding fruitItemBinding;

        public FruitViewHolder(FruitItemBinding fruitItemBinding) {
            super(fruitItemBinding.getRoot());
            this.fruitItemBinding = fruitItemBinding;
        }
    }

    @NonNull
    @Override
    public FruitAdapter.FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FruitItemBinding binding = FruitItemBinding.inflate(layoutInflater, parent, false);
        return new FruitViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.FruitViewHolder holder, int position) {
    Fruit fruit = fruitList.get(position);

    holder.fruitItemBinding.setFruit(fruit);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
