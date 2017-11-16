package com.example.testale.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.testale.Commons.Constants;
import com.example.testale.Commons.ProductAttributes;
import com.example.testale.R;
import com.example.testale.Utils.Util;
import com.example.testale.model.DataProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Martha Toledano on 16/11/2017.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    private List<DataProduct> dataProducts;


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        ImageView plusLevelProduct;
        ImageView conditionProduct;
        ImageView importProduct;
        ImageView freeShippingProduct;
        View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            productImage = v.findViewById(R.id.productImage);
            plusLevelProduct = v.findViewById(R.id.plusLevelProduct);
            conditionProduct = v.findViewById(R.id.conditionProduct);
            importProduct = v.findViewById(R.id.importProduct);
            freeShippingProduct = v.findViewById(R.id.freeShippingProduct);
        }
    }

    public void add(int position, DataProduct item) {
        dataProducts.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        dataProducts.remove(position);
        notifyItemRemoved(position);
    }

    public FavoritesAdapter(List<DataProduct> myDataset) {
        dataProducts = myDataset;
    }

    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.favorite_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final DataProduct data = dataProducts.get(position);

        //      holder.productImage.setImageBitmap(Util.getImageByUrl(data.getImage(), holder.layout.getContext()));
        Picasso.with(holder.layout.getContext()).load(data.getImage()).fit().into(holder.productImage);

        ProductAttributes productAttributes = Util.getAtributesResProduct(data.getLinioPlusLevel(), data.getConditionType(), data.isImported(), data.isFreeShipping());

        if (productAttributes.getPlusLevelProduct() != Constants.NO_SHOW) {
            holder.plusLevelProduct.setVisibility(View.VISIBLE);
            holder.plusLevelProduct.setImageResource(productAttributes.getPlusLevelProduct());
        } else {
            holder.plusLevelProduct.setVisibility(View.GONE);
        }

        if (productAttributes.getConditionProduct() != Constants.NO_SHOW) {
            holder.conditionProduct.setVisibility(View.VISIBLE);
            holder.conditionProduct.setImageResource(productAttributes.getConditionProduct());
        } else {
            holder.conditionProduct.setVisibility(View.GONE);
        }

        if (productAttributes.getImportProduct() != Constants.NO_SHOW) {
            holder.importProduct.setVisibility(View.VISIBLE);
            holder.importProduct.setImageResource(productAttributes.getImportProduct());
        } else {
            holder.importProduct.setVisibility(View.GONE);
        }

        if (productAttributes.getFreeShippingProduct() != Constants.NO_SHOW) {
            holder.freeShippingProduct.setVisibility(View.VISIBLE);
            holder.freeShippingProduct.setImageResource(productAttributes.getFreeShippingProduct());

        } else {
            holder.freeShippingProduct.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return dataProducts.size();
    }
}
