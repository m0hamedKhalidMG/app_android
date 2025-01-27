package com.example.ejargoplus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class UploadActivity extends AppCompatActivity {

        private static final int FILE_SELECT_CODE = 0;
        private TextView selectedFileNameTextView;
        private Button uploadButton;
        private Button submitButton;
        private String selectedFilePath;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upload);

            // Initialize views
            selectedFileNameTextView = findViewById(R.id.selectedFileName);
            uploadButton = findViewById(R.id.uploadButton);
            submitButton = findViewById(R.id.submitButton);

            // File selection logic
            uploadButton.setOnClickListener(v -> openFileSelector());

            // Upload button (Submit the document)
            submitButton.setOnClickListener(v -> {
                if (selectedFilePath != null) {
                    uploadDocument();
                } else {
                    Toast.makeText(this, "Please select a file first", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Opens a file picker to select the document
        private void openFileSelector() {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");  // Allows any type of file
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            filePickerResultLauncher.launch(intent); // Using new ActivityResult API
        }

        // The ActivityResult API callback to handle file selection
        private final ActivityResultCallback<ActivityResult> filePickerResultCallback = result -> {
            if (result.getResultCode() == RESULT_OK) {
                Uri selectedUri = result.getData().getData();
                if (selectedUri != null) {
                    selectedFilePath = selectedUri.getPath();
                    selectedFileNameTextView.setText(selectedFilePath); // Show the selected file path
                }
            }
        };

        // ActivityResultLauncher for the file picker
        private final ActivityResultLauncher<Intent> filePickerResultLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), filePickerResultCallback);

        // Handle the file upload logic
        private void uploadDocument() {
            // Perform the document upload logic here (e.g., send file to a server)
            Toast.makeText(this, "Document uploaded successfully!", Toast.LENGTH_SHORT).show();
        }
    }