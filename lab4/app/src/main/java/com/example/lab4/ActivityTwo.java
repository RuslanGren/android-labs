package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Перше питання тесту
 */
public class ActivityTwo extends AppCompatActivity {

    private Button nextBtn;
    private TextView feedbackTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        feedbackTxt = findViewById(R.id.tvResult);
        nextBtn = findViewById(R.id.btnNext);

        nextBtn.setOnClickListener(v -> goToNext());
    }

    private void goToNext() {
        startActivity(new Intent(ActivityTwo.this, ActivityThree.class));
    }

    public void wrongAnswer(View view) {
        updateFeedback("Ні, це інший компонент :)", Color.RED);
    }

    public void correctAnswer(View view) {
        updateFeedback("Так! Activity представляє один екран застосунку.", Color.GREEN);
    }

    private void updateFeedback(String message, int color) {
        feedbackTxt.setText(message);
        feedbackTxt.setTextColor(color);
    }
}
