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

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ImageView ivBack = findViewById(R.id.iv_back);

        // Set a click listener
        ivBack.setOnClickListener(view -> {
            // Navigate to the home screen
            Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Optional: Close the current activity
        });

    }

    public void nagvaitetoUpload(View view) {
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }
}