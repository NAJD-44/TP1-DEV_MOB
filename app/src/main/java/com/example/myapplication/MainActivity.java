package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private EditText NP;
    private EditText EM;
    private EditText ADD;
    private EditText PH;

    private Spinner V;
    private Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bn = findViewById(R.id.bn);
        NP = findViewById(R.id.NP);
        EM = findViewById(R.id.editTextText2);
        PH = findViewById(R.id.phone);
        ADD= findViewById(R.id.editTextText3);
        V= findViewById(R.id.villes);

        bn.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String name = NP.getText().toString();
                                      String email = EM.getText().toString();
                                      String address = ADD.getText().toString();
                                      String phone = PH.getText().toString();
                                      String ville = V.getSelectedItem().toString();

                                      Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                                      intent.putExtra("NAME", name);
                                      intent.putExtra("EMAIL", email);
                                      intent.putExtra("ADDRESS", address);
                                      intent.putExtra("PHONE", phone);
                                      intent.putExtra("VILLE", ville);

                                      startActivity(intent);
                                  }
                              }

        );


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}