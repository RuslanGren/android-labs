package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * Завершальний екран
 */
public class ActivityFive extends AppCompatActivity {

    private Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        homeBtn = findViewById(R.id.btnHome);

        homeBtn.setOnClickListener(v -> returnHome());
    }

    private void returnHome() {
        startActivity(new Intent(ActivityFive.this, MainActivity.class));
    }
}
