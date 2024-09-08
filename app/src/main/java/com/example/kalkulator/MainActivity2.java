package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView resultTextView, nimTextView, nameTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultTextView = findViewById(R.id.resultTextView);
        nimTextView = findViewById(R.id.nimTextView);
        nameTextView = findViewById(R.id.nameTextView);
        backButton = findViewById(R.id.backButton);

        // Dapatkan data dari Intent
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        String nim = intent.getStringExtra("nim");
        String name = intent.getStringExtra("name");

        // Cek jika hasil adalah bilangan bulat
        double resultValue = Double.parseDouble(result);
        if (resultValue == (int) resultValue) {
            // Jika hasil adalah bilangan bulat, tampilkan tanpa koma
            resultTextView.setText("Hasil: " + String.valueOf((int) resultValue));
        } else {
            // Jika hasil memiliki desimal, tampilkan dengan desimal
            resultTextView.setText("Hasil: " + result);
        }

        // Set nilai ke TextView untuk NIM dan Nama
        nimTextView.setText("NIM: " + nim);
        nameTextView.setText("Nama: " + name);

        // Tombol kembali ke MainActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke activity sebelumnya
            }
        });
    }
}