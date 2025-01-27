package com.example.ejargoplus;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class featuresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_features);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad("EGP 9,000,000", "Apartment for sale inside Village West Dorra Compound...",
                "Sheikh Zayed, Giza", R.drawable.bg3));
        ads.add(new Ad("EGP 4,000,000", "For quick sale, an 81m apartment in installments...",
                "Sarai, Mostakbal City", R.drawable.bg4));
        ads.add(new Ad("EGP 9,000,000", "Apartment for sale inside Village West Dorra Compound...",
                "Sheikh Zayed, Giza", R.drawable.bg3));
        ads.add(new Ad("EGP 4,000,000", "For quick sale, an 81m apartment in installments...",
                "Sarai, Mostakbal City", R.drawable.bg4));
        ads.add(new Ad("EGP 9,000,000", "Apartment for sale inside Village West Dorra Compound...",
                "Sheikh Zayed, Giza", R.drawable.bg3));
        ads.add(new Ad("EGP 4,000,000", "For quick sale, an 81m apartment in installments...",
                "Sarai, Mostakbal City", R.drawable.bg4));
        // Add more ads as needed...

        AdAdapter adapter = new AdAdapter(ads);
        recyclerView.setAdapter(adapter);
        };

}