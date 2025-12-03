package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView label;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.helloWorld);
        button = findViewById(R.id.myButton);
        button.setOnClickListener(view -> {
            updateLabel();
            showToastMessage();
        });
    }

    private void updateLabel() {
        label.setText("it's working!");
    }

    private void showToastMessage() {
        Toast.makeText(
                MainActivity.this,
                "button was pressed",
                Toast.LENGTH_SHORT
        ).show();
    }
}