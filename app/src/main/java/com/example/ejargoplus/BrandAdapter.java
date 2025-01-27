package com.example.ejargoplus;

// BrandAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {
    private List<BrandItem> brandItemList;

    // Constructor to initialize the brand items list
    public BrandAdapter(List<BrandItem> brandItemList) {
        this.brandItemList = brandItemList;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item (brand_item.xml)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_brand_item, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        // Set the brand image for the item at the given position
        BrandItem currentItem = brandItemList.get(position);
        holder.brandImage.setImageResource(currentItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return brandItemList.size();
    }

    // ViewHolder class to hold the image view
    public static class BrandViewHolder extends RecyclerView.ViewHolder {
        public ImageView brandImage;

        public BrandViewHolder(View itemView) {
            super(itemView);
            brandImage = itemView.findViewById(R.id.brandImage); // Bind the ImageView
        }
    }
}
