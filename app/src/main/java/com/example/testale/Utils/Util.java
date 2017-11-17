package com.example.testale.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.testale.Commons.ProductAttributes;
import com.example.testale.R;

import java.io.IOException;
import java.io.InputStream;
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
    /**
     * Reglas para mostrar los badge.
     *
     * @param linioPlusLevel
     * @param conditionType
     * @param isImported
     * @param isFreeShipping
     * @return
     */
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

    public static String loadJSONFromAssets(final Context context, final String nameFile) {
        String json;
        try {
            InputStream is = context.getAssets().open(nameFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
