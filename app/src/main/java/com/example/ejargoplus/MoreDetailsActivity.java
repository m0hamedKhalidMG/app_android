package com.example.ejargoplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
public class MoreDetailsActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TextView imageNumber;
    private ImageView cameraIcon;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "PhotoScrollPreferences";
    private static final String KEY_PAGE_POSITION = "LastPagePosition";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        LinearLayout companyProfile = findViewById(R.id.companyProfile);

        // Set click listener
        companyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the ProfileActivity
                Intent intent = new Intent(MoreDetailsActivity.this, ProfileDeveloperActivity.class);
                startActivity(intent);
            }
        });
        View rootView = findViewById(R.id.rootLayout);
        rootView.setOnApplyWindowInsetsListener((view, insets) -> {
            int statusBarHeight = insets.getSystemWindowInsetTop(); // الحصول على ارتفاع شريط الحالة
            view.setPadding(0, statusBarHeight, 0, 0); // إضافة مساحة علوية
            return insets;
        });
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity
                finish();
            }
        });
        imageNumber = findViewById(R.id.imageNumber);
        cameraIcon = findViewById(R.id.cameraIcon);
            sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            // Image slider setup
            viewPager = findViewById(R.id.viewPager);
            ArrayList<Integer> images = new ArrayList<>(Arrays.asList(
                    R.drawable.ejary, R.drawable.bg4, R.drawable.background,
                    R.drawable.bg3
            ));

            ImageSliderAdapter adapter = new ImageSliderAdapter(images);
            viewPager.setAdapter(adapter);

            // Restore last page position
            int lastPosition = sharedPreferences.getInt(KEY_PAGE_POSITION, 0);
            viewPager.setCurrentItem(lastPosition);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Display the current image number (position + 1, since position is 0-based)
                int currentImage = position + 1;  // Page numbers start from 1
                int totalImages = adapter.getItemCount(); // Get total image count
                imageNumber.setText(currentImage + " / " + totalImages);
            }
        });

            // Save the current page position on page change
            viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    sharedPreferences.edit().putInt(KEY_PAGE_POSITION, position).apply();
                }
            });
        }
}