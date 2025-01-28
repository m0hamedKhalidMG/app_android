package com.example.ejargoplus;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdAdapter extends RecyclerView.Adapter<AdAdapter.AdViewHolder> {

    private final List<Ad> ads;

    public AdAdapter(List<Ad> ads) {
        this.ads = ads;
    }

    @NonNull
    @Override
    public AdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ad, parent, false);
        return new AdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdViewHolder holder, int position) {
        Ad ad = ads.get(position);
        holder.price.setText(ad.getPrice());
        holder.details.setText(ad.getDetails());
        holder.location.setText(ad.getLocation());
        holder.image.setImageResource(ad.getImageResId());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MoreDetailsActivity.class);
            intent.putExtra("adPrice", ad.getPrice());
            intent.putExtra("adDetails", ad.getDetails());
            intent.putExtra("adLocation", ad.getLocation());
            intent.putExtra("adImageResId", ad.getImageResId());
            v.getContext().startActivity(intent);
        });
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