package com.example.a2f_a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button sendOtpButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.editTextEmail);
        passwordInput = findViewById(R.id.editTextPassword);
        sendOtpButton = findViewById(R.id.buttonSendOtp);

        // OTP
        sendOtpButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            // emaili i vlefshem
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                return;
            }


            if (isValidCredentials(email, password)) {
                //sakte
                Intent intent = new Intent(this, OtpActivity.class);
                intent.putExtra("recipient", email);
                startActivity(intent);
            } else {
                //  mesazh gabimi
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private boolean isValidCredentials(String email, String password) {
        return email.equals("besarta.mustafa4@student.uni-pr.edu") && password.equals("besarta");
    }
}
