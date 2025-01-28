package com.example.ejargoplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private BrandAdapter brandAdapter;
    private List<BrandItem> brandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        Button addFundsButton = findViewById(R.id.addFundsButton);
        addFundsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Fund page
                Intent intent = new Intent(HomeActivity.this, RequestFundActivity.class);
                startActivity(intent);
            }
        });
        View rootView = findViewById(R.id.rootLayout);

        rootView.setOnApplyWindowInsetsListener((view, insets) -> {
            int statusBarHeight = insets.getSystemWindowInsetTop();
            view.setPadding(0, statusBarHeight, 0, 0); // إضافة مساحة علوية
            return insets;
        });
        TextView seeAllVillasForSale = findViewById(R.id.seeAllVillasForSale);
        seeAllVillasForSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the DetailsActivity
                Intent intent = new Intent(HomeActivity.this, featuresActivity.class);
                startActivity(intent);
            }
        });
        // Setting up Ads RecyclerView
        RecyclerView recyclerView = findViewById(R.id.saleRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
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

        SaleAdapter adapter = new SaleAdapter(ads);
        recyclerView.setAdapter(adapter);

        // Setting up Brand RecyclerView
        brandList = new ArrayList<>();
        brandList.add(new BrandItem(R.drawable.ejary2));  // Add your image resource here
        brandList.add(new BrandItem(R.drawable.ejary2));
        brandList.add(new BrandItem(R.drawable.ejary2));
        brandList.add(new BrandItem(R.drawable.ejary2));

        // Correctly refer to the brand RecyclerView
        RecyclerView recyclerViewbrand = findViewById(R.id.favoriteBrandsRecyclerView);

        // Set up the layout manager for the brand RecyclerView
        LinearLayoutManager layoutManagerbrand = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewbrand.setLayoutManager(layoutManagerbrand);

        // Initialize the BrandAdapter and set it to the brand RecyclerView
        brandAdapter = new BrandAdapter(brandList);
        recyclerViewbrand.setAdapter(brandAdapter);


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
}
