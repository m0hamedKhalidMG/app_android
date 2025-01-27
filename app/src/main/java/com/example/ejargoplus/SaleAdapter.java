package com.example.ejargoplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.AdViewHolder>{
    private final List<Ad> ads;

    public SaleAdapter(List<Ad> ads) {
        this.ads = ads;
    }

    @NonNull
    @Override
    public SaleAdapter.AdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sale_item, parent, false);
        return new SaleAdapter.AdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleAdapter.AdViewHolder holder, int position) {
        Ad ad = ads.get(position);
        holder.price.setText(ad.getPrice());
        holder.details.setText(ad.getDetails());
        holder.location.setText(ad.getLocation());
        holder.image.setImageResource(ad.getImageResId());
    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    static class AdViewHolder extends RecyclerView.ViewHolder {
        TextView price, details, location;
        ImageView image;

        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.textViewPrice);
            details = itemView.findViewById(R.id.textViewDetails);
            location = itemView.findViewById(R.id.textViewLocation);
            image = itemView.findViewById(R.id.imageViewAd);
        }
    }
}