package com.example.testale.Server;

import com.example.testale.Server.Response.CollectionResponse;
import com.example.testale.Server.Response.Owner;
import com.example.testale.Server.Response.Product;
import com.example.testale.Utils.Util;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.testale.Commons.Constants.PRODUCT_TAGS;


/**
 * Created by Martha Toledano on 16/11/2017.
 */

public class DataJson {

    public List<CollectionResponse> getProducts(final String json) {
        List<CollectionResponse> list = null;

        try {
            JSONArray main = new JSONArray(json);
            list = new ArrayList<>();
            for (int i = 0; i < main.length(); i++) {
                CollectionResponse cr = new CollectionResponse();

                JSONObject collectionInfo = main.getJSONObject(i);

                cr.setId(collectionInfo.optInt("id"));
                cr.setName(collectionInfo.optString("name"));
                cr.setDescription(collectionInfo.optString("description"));
                cr.setDefult(collectionInfo.optBoolean("default"));
                cr.setCreatedAt(collectionInfo.getString("createdAt"));
                cr.setVisibility(collectionInfo.optString("visibility"));

                JSONObject ownerInfo = collectionInfo.optJSONObject("owner");

                Owner owner = new Owner();

                owner.setName(ownerInfo.optString("name"));
                owner.setEmail(ownerInfo.optString("email"));
                owner.setLinioId(ownerInfo.optString("linioId"));

                cr.setOwner(owner);

                JSONObject productsInfo = collectionInfo.optJSONObject("products");

                List<Product> listProduct = new ArrayList<>();

                for (String tag : PRODUCT_TAGS) {
                    final String tagProduct = productsInfo.optString(tag);
                    if (Util.isValidString(tagProduct)) {
                        JSONObject productTagInfo = productsInfo.optJSONObject(tag);
                        Product product = new Product();
                        product.setTag(tag);
                        product.setId(productTagInfo.optInt("id"));
                        product.setName(productTagInfo.optString("name"));
                        product.setWishListPrice(productTagInfo.optDouble("wishListPrice"));
                        product.setSlug(productTagInfo.optString("slug"));
                        product.setUrl(productTagInfo.optString("url"));
                        product.setImage(productTagInfo.optString("image"));
                        product.setLinioPlusLevel(productTagInfo.optInt("linioPlusLevel"));
                        product.setConditionType(productTagInfo.optString("conditionType"));
                        product.setFreeShipping(productTagInfo.optBoolean("freeShipping"));
                        product.setImported(productTagInfo.optBoolean("imported"));
                        product.setActive(productTagInfo.optBoolean("active"));
                        listProduct.add(product);
                    }
                }

                cr.setProducts(listProduct);
                list.add(cr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
