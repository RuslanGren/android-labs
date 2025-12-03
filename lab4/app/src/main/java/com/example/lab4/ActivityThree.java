package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Друге питання тесту
 */
public class ActivityThree extends AppCompatActivity {

    private Button nextBtn;
    private TextView answerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        answerInfo = findViewById(R.id.tvResult);
        nextBtn = findViewById(R.id.btnNext);

        nextBtn.setOnClickListener(v -> proceed());
    }

    private void proceed() {
        startActivity(new Intent(ActivityThree.this, ActivityFour.class));
    }

    public void wrongAnswer(View view) {
        display("Ні, у цьому файлі зберігаються інші ресурси.", Color.RED);
    }

    public void correctAnswer(View view) {
        display("Так! Рядки зберігаються у res/values/strings.xml.", Color.GREEN);
    }

    private void display(String text, int color) {
        answerInfo.setText(text);
        answerInfo.setTextColor(color);
    }
}
