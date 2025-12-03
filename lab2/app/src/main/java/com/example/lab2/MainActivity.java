package com.example.lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(view -> sendNotification());
    }

    private void sendNotification() {
        Toast.makeText(
                MainActivity.this,
                "meow meow meow",
                Toast.LENGTH_SHORT
        ).show();
    }
}