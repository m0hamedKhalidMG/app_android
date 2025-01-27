package com.example.ejargoplus;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class FilterActivity extends AppCompatActivity {

    private Spinner spinnerLocation, spinnerType, spinnerBathrooms, spinnerBedrooms;
    private String selectedLocation = "Egypt,Alexandri"; // Default value
    private String selectedType = "Any"; // Default value
    private String selectedBathrooms = "Any"; // Default value
    private String selectedBedrooms = "Any"; // Default value;

    private EditText priceMin, priceMax, areaMin, areaMax, downPaymentMin, downPaymentMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        // Initialize views
        spinnerLocation = findViewById(R.id.spinnerLocation);
        spinnerType = findViewById(R.id.spinnerType);
        spinnerBathrooms = findViewById(R.id.spinnerBathrooms);
        spinnerBedrooms = findViewById(R.id.spinnerBedrooms);

        priceMin = findViewById(R.id.priceMin);
        priceMax = findViewById(R.id.priceMax);
        areaMin = findViewById(R.id.areaMin);
        areaMax = findViewById(R.id.areaMax);
        downPaymentMin = findViewById(R.id.downPaymentMin);
        downPaymentMax = findViewById(R.id.downPaymentMax);

        ImageView btnClose = findViewById(R.id.btnClose);
        TextView btnClearAll = findViewById(R.id.btnClearAll);
        Button btnSeeResult = findViewById(R.id.btnSeeResult);

        // Populate Location Spinner
        String[] locations = {"Egypt,Alexandri", "Egypt,Cairo", "Egypt,Giza", "Egypt,Port Said", "Egypt,Banha"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(locationAdapter);

        // Populate Type Spinner
        String[] types = {"Any", "Apartment", "Villa", "Townhouse", "Office"};
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);

        // Populate Bathrooms Spinner
        String[] bathrooms = {"Any", "1", "2", "3", "4", "5+"};
        ArrayAdapter<String> bathroomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bathrooms);
        bathroomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBathrooms.setAdapter(bathroomAdapter);

        // Populate Bedrooms Spinner
        String[] bedrooms = {"Any", "1", "2", "3", "4", "5+"};
        ArrayAdapter<String> bedroomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bedrooms);
        bedroomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBedrooms.setAdapter(bedroomAdapter);

        // Handle Spinner Selections
        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLocation = locations[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedType = types[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerBathrooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBathrooms = bathrooms[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerBedrooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBedrooms = bedrooms[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Handle Close Button
        btnClose.setOnClickListener(v -> finish());

        // Handle Clear All
        btnClearAll.setOnClickListener(v -> {
            spinnerLocation.setSelection(0);
            spinnerType.setSelection(0);
            spinnerBathrooms.setSelection(0);
            spinnerBedrooms.setSelection(0);

            priceMin.setText("");
            priceMax.setText("");
            areaMin.setText("");
            areaMax.setText("");
            downPaymentMin.setText("");
            downPaymentMax.setText("");

            Toast.makeText(this, "Filters cleared", Toast.LENGTH_SHORT).show();
        });

        // Handle See Results Button
        btnSeeResult.setOnClickListener(v -> {
            Toast.makeText(this, "Fetching results...", Toast.LENGTH_SHORT).show();
            // Handle search logic here
        });
    }
}