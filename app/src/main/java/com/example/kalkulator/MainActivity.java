package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText num1EditText, num2EditText;
    private RadioGroup operationGroup;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        operationGroup = findViewById(R.id.operationGroup);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String num1String = num1EditText.getText().toString();
        String num2String = num2EditText.getText().toString();

        if (num1String.isEmpty() || num2String.isEmpty()) {
            Toast.makeText(this, "Harap masukkan kedua angka", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1String);
        double num2 = Double.parseDouble(num2String);

        int selectedOperationId = operationGroup.getCheckedRadioButtonId();
        double result = 0;

        if (selectedOperationId == R.id.radioAdd) {
            result = num1 + num2;
        } else if (selectedOperationId == R.id.radioSubtract) {
            result = num1 - num2;
        } else if (selectedOperationId == R.id.radioMultiply) {
            result = num1 * num2;
        } else if (selectedOperationId == R.id.radioDivide) {
            if (num2 == 0) {
                Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        } else {
            Toast.makeText(this, "Harap pilih operasi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kirim hasil perhitungan ke ResultActivity
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("result", String.valueOf(result));
        intent.putExtra("nim", "225150401111011"); // Ganti dengan NIM yang diinginkan
        intent.putExtra("name", "Hathisha Radiskha Poetri"); // Ganti dengan nama yang diinginkan
        startActivity(intent);
    }
}
