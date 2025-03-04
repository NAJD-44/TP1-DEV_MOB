package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private TextView villeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        addressTextView = findViewById(R.id.addressTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        villeTextView = findViewById(R.id.villeTextView);

        // Get the intent that started this activity
        Intent intent = getIntent();

        // Retrieve the data passed from MainActivity
        String name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("EMAIL");
        String address = intent.getStringExtra("ADDRESS");
        String phone = intent.getStringExtra("PHONE");
        String ville = intent.getStringExtra("VILLE");


        nameTextView.setText("Nom: " + name);
        emailTextView.setText("Email: " + email);
        addressTextView.setText("Addresse: " + address);
        phoneTextView.setText("Phone: " + phone);
        villeTextView.setText("Ville: " + ville);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}