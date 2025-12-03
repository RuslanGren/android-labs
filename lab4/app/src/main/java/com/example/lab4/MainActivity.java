package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startQuizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startQuizBtn = findViewById(R.id.btnStart);

        startQuizBtn.setOnClickListener(view -> openQuestionOne());
    }

    private void openQuestionOne() {
        startActivity(new Intent(MainActivity.this, ActivityTwo.class));
    }
}
