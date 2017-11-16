package com.example.testale;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testale.Adapters.FavoritesAdapter;
import com.example.testale.Commons.Constants;
import com.example.testale.model.DataProduct;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView favorites;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        favorites = (RecyclerView) findViewById(R.id.favorites);
        //favorites.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        favorites.setLayoutManager(layoutManager);
        List<DataProduct> input = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            DataProduct dataProduct = new DataProduct();
            dataProduct.setConditionType(Constants.CONDITION_TYPE_REFURBISHED);
            dataProduct.setFreeShipping(false);
            dataProduct.setImage("https://i.linio.com/p/c97a50b1c6c7e3bb2c48c1b4104d5975-product.jpg");
            dataProduct.setImported(false);
            dataProduct.setLinioPlusLevel(Constants.LINIO_PLUS_LEVEL_1);
            input.add(dataProduct);
        }
        adapter = new FavoritesAdapter(input);
        favorites.setAdapter(adapter);

    }
}
