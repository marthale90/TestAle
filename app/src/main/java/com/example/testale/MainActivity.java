package com.example.testale;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testale.Adapters.FavoritesAdapter;
import com.example.testale.Server.DataJson;
import com.example.testale.Server.Response.CollectionResponse;
import com.example.testale.Server.Response.Product;
import com.example.testale.Utils.Util;
import com.example.testale.model.DataProduct;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.input;

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
        DataJson dataJson = new DataJson();
        final String jsonFromAssets = Util.loadJSONFromAssets(this, "json.json");
        List<CollectionResponse> collectionResponses = dataJson.getProducts(jsonFromAssets);
        List<DataProduct> input = new ArrayList<>();

        for (CollectionResponse coll : collectionResponses) {
            List<Product> products = coll.getProducts();
            for (Product p : products) {
                DataProduct dp = new DataProduct();
                dp.setImported(p.isImported());
                dp.setLinioPlusLevel(p.getLinioPlusLevel());
                dp.setImage(p.getImage());
                dp.setFreeShipping(p.isFreeShipping());
                dp.setConditionType(p.getConditionType());
                input.add(dp);
            }
        }


        adapter = new FavoritesAdapter(input);
        favorites.setAdapter(adapter);

    }
}
