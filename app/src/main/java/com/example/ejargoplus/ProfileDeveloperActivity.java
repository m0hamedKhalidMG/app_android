package com.example.ejargoplus;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileDeveloperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_developer);
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity
                finish();
            }
        });
        View rootView = findViewById(R.id.rootLayout);
        rootView.setOnApplyWindowInsetsListener((view, insets) -> {
            int statusBarHeight = insets.getSystemWindowInsetTop(); // الحصول على ارتفاع شريط الحالة
            view.setPadding(0, statusBarHeight, 0, 0); // إضافة مساحة علوية
            return insets;
        });


    }
}