package com.example.ejargoplus;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        View rootView = findViewById(R.id.rootLayout);
        rootView.setOnApplyWindowInsetsListener((view, insets) -> {
            int statusBarHeight = insets.getSystemWindowInsetTop(); // الحصول على ارتفاع شريط الحالة
            view.setPadding(0, statusBarHeight, 0, 0); // إضافة مساحة علوية
            return insets;
        });
    }

    // This method is called when the TextView is clicked
    public void navigateToSignUp(View view) {
        Intent intent = new Intent(this, MoreDetailsActivity.class);
        startActivity(intent);
    }

    public void navigatefeatures(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
