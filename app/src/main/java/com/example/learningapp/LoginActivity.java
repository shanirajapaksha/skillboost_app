package com.example.learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField, passwordField;

    // Hardcoded user credentials
    private static final String EMAIL = "shani@gmail.com";
    private static final String PASSWORD = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.pd);
        Button btnLogin = findViewById(R.id.btnlogin);

        // Login button click event
        btnLogin.setOnClickListener(v -> validateAndLogin());

        // Sign-up redirection
        TextView btnSignUp = findViewById(R.id.textViewSignUp);
        btnSignUp.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private void validateAndLogin() {
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        // Validation for empty fields
        if (email.isEmpty()) {
            emailField.setError("Email is required");
            emailField.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordField.setError("Password is required");
            passwordField.requestFocus();
            return;
        }

        // Hardcoded credentials check
        if (email.equals(EMAIL) && password.equals(PASSWORD)) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomehomeActivity.class));  // Navigate to the next activity
        } else {
            Toast.makeText(this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
