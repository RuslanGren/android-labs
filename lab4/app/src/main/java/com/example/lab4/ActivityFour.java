package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Третє питання тесту
 */
public class ActivityFour extends AppCompatActivity {

    private Button nextActivityBtn;
    private TextView statusTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        statusTxt = findViewById(R.id.tvResult);
        nextActivityBtn = findViewById(R.id.btnNext);

        nextActivityBtn.setOnClickListener(v -> goNext());
    }

    private void goNext() {
        startActivity(new Intent(ActivityFour.this, ActivityFive.class));
    }

    public void wrongAnswer(View v) {
        update("Ні, цей контейнер працює по-іншому.", Color.RED);
    }

    public void correctAnswer(View v) {
        update("Правильно! LinearLayout розміщує елементи один під одним (при vertical).", Color.GREEN);
    }

    private void update(String text, int color) {
        statusTxt.setText(text);
        statusTxt.setTextColor(color);
    }
}
