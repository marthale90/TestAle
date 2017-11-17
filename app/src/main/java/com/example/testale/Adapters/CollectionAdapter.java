package com.example.testale.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testale.R;
import com.example.testale.model.DataCollection;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Martha Toledano on 17/11/2017.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {
    private List<DataCollection> collections;


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView product1;
        ImageView product2;
        ImageView product3;
        TextView nameCollection;
        TextView countCollection;

        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            product1 = v.findViewById(R.id.product1);
            product2 = v.findViewById(R.id.product2);
            product3 = v.findViewById(R.id.product3);
            nameCollection = v.findViewById(R.id.nameCollection);
            countCollection = v.findViewById(R.id.countCollection);
        }
    }

    public void add(int position, DataCollection item) {
        collections.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        collections.remove(position);
        notifyItemRemoved(position);
    }

    public CollectionAdapter(List<DataCollection> myDataset) {
        collections = myDataset;
    }

    @Override
    public CollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.collection_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final DataCollection data = collections.get(position);

        Picasso.with(holder.layout.getContext()).load(data.getImgP1()).fit().into(holder.product1);
        Picasso.with(holder.layout.getContext()).load(data.getImgP2()).fit().into(holder.product2);
        Picasso.with(holder.layout.getContext()).load(data.getImgP3()).fit().into(holder.product3);

        holder.nameCollection.setText(data.getName());
        holder.countCollection.setText(data.getTotal());
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }
}
