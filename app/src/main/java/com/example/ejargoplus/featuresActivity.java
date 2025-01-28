package com.example.ejargoplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class featuresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_features);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        View rootView = findViewById(R.id.rootLayout);
        rootView.setOnApplyWindowInsetsListener((view, insets) -> {
            int statusBarHeight = insets.getSystemWindowInsetTop(); // الحصول على ارتفاع شريط الحالة
            view.setPadding(0, statusBarHeight, 0, 0); // إضافة مساحة علوية
            return insets;
        });

        ImageView filterIcon = findViewById(R.id.filterIcon);

        // Set click listener
        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to FilterActivity
                Intent intent = new Intent(featuresActivity.this, FilterActivity.class);
                startActivity(intent);
            }
        });
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


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    return true;

                case R.id.docs:
                    Intent intent = new Intent(this, UploadActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.profile:
                    Intent intent3 = new Intent(this, ProfileActivity.class);
                    startActivity(intent3);
                    return true;

                case R.id.favorite:
                    Intent intent2 = new Intent(this, FilterActivity.class);
                    startActivity(intent2);
                    return true;
                default:
                    return false; // Return false if no case matches
            }
        });
    }
        };

