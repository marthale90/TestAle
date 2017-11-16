package com.example.testale.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.testale.Commons.ProductAttributes;
import com.example.testale.R;

import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.testale.Commons.Constants.CONDITION_TYPE_NEW;
import static com.example.testale.Commons.Constants.CONDITION_TYPE_REFURBISHED;
import static com.example.testale.Commons.Constants.LINIO_PLUS_LEVEL_1;
import static com.example.testale.Commons.Constants.LINIO_PLUS_LEVEL_2;

/**
 * Created by Martha Toledano on 15/11/2017.
 */

public class Util {

    public static ProductAttributes getAtributesResProduct(final int linioPlusLevel, final String conditionType, final boolean isImported, final boolean isFreeShipping) {
        ProductAttributes productAttributes = new ProductAttributes();

        switch (linioPlusLevel) {
            case LINIO_PLUS_LEVEL_1:
                productAttributes.setPlusLevelProduct(R.drawable.ic_nd_ic_plus_30);
                break;
            case LINIO_PLUS_LEVEL_2:
                productAttributes.setPlusLevelProduct(R.drawable.ic_nd_ic_plus_48_30);
                break;
        }

        if (isValidString(conditionType)) {
            switch (conditionType) {
                case CONDITION_TYPE_REFURBISHED:
                    productAttributes.setConditionProduct(R.drawable.ic_nd_ic_refurbished_30);
                    break;
                case CONDITION_TYPE_NEW:
                    productAttributes.setConditionProduct(R.drawable.ic_nd_ic_new_30);
                    break;
            }
        }

        if (isImported) {
            productAttributes.setImportProduct(R.drawable.ic_nd_ic_international_30);
        }

        if (isFreeShipping) {
            productAttributes.setFreeShippingProduct(R.drawable.ic_nd_ic_free_shipping_30);
        }

        return productAttributes;
    }

    public static boolean isValidString(final String string) {
        boolean flag = false;
        if (string != null && !string.trim().isEmpty() && !string.trim().equals("")) {
            flag = true;
        }
        return flag;
    }

    public static Bitmap getImageByUrl(final String urlString, final Context context) {
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bitmap == null)
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.default_image);

        return bitmap;
    }
}
