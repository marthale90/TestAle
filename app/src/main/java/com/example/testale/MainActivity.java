package com.example.testale;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.testale.Adapters.CollectionAdapter;
import com.example.testale.Adapters.FavoritesAdapter;
import com.example.testale.Server.DataJson;
import com.example.testale.Server.Response.CollectionResponse;
import com.example.testale.Server.Response.Product;
import com.example.testale.Utils.Util;
import com.example.testale.model.DataCollection;
import com.example.testale.model.DataProduct;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView favorites;
    private RecyclerView.Adapter adapterFav;
    private RecyclerView.LayoutManager layoutManagerFav;

    private RecyclerView collections;
    private RecyclerView.Adapter adapterColl;
    private RecyclerView.LayoutManager layoutManagerColl;

    private TextView titleCountFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favorites = (RecyclerView) findViewById(R.id.favorites);
        titleCountFav = (TextView) findViewById(R.id.titleCountFav);
        layoutManagerFav = new GridLayoutManager(this, 2);
        favorites.setLayoutManager(layoutManagerFav);

        collections = (RecyclerView) findViewById(R.id.collections);
        layoutManagerColl = new GridLayoutManager(this, 2);
        collections.setLayoutManager(layoutManagerColl);

        DataJson dataJson = new DataJson();
        final String jsonFromAssets = Util.loadJSONFromAssets(this, "json.json");
        List<CollectionResponse> collectionResponses = dataJson.getProducts(jsonFromAssets);

        List<DataProduct> favList = new ArrayList<>();
        List<DataCollection> collectionList = new ArrayList<>();

        for (CollectionResponse coll : collectionResponses) {
            DataCollection dc = new DataCollection();
            List<Product> products = coll.getProducts();
            int countProd = 1;
            for (Product p : products) {
                DataProduct dp = new DataProduct();
                dp.setImported(p.isImported());
                dp.setLinioPlusLevel(p.getLinioPlusLevel());
                dp.setImage(p.getImage());
                dp.setFreeShipping(p.isFreeShipping());
                dp.setConditionType(p.getConditionType());
                favList.add(dp);

                switch (countProd) {
                    case 1:
                        dc.setImgP1(p.getImage());
                        break;
                    case 2:
                        dc.setImgP2(p.getImage());
                        break;
                    case 3:
                        dc.setImgP3(p.getImage());
                        break;
                }

                countProd++;
            }

            dc.setName(coll.getName());
            dc.setTotal(String.valueOf(coll.getProducts().size()));

            collectionList.add(dc);
        }

        titleCountFav.setText(String.format(getString(R.string.title_all_fav), String.valueOf(favList.size())));

        adapterFav = new FavoritesAdapter(favList);
        favorites.setAdapter(adapterFav);

        adapterColl = new CollectionAdapter(collectionList);
        collections.setAdapter(adapterColl);


    }
}
