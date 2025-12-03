package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int pointsA = 0;
    private int pointsB = 0;

    private TextView viewA;
    private TextView viewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewA = findViewById(R.id.scoreA);
        viewB = findViewById(R.id.scoreB);
    }

    public void addTripleA(View view) {
        pointsA += 3;
        updateA();
    }

    public void addDoubleA(View view) {
        pointsA += 2;
        updateA();
    }

    public void addSingleA(View view) {
        pointsA += 1;
        updateA();
    }

    private void updateA() {
        viewA.setText(String.valueOf(pointsA));
    }


    public void addTripleB(View view) {
        pointsB += 3;
        updateB();
    }

    public void addDoubleB(View view) {
        pointsB += 2;
        updateB();
    }

    public void addSingleB(View view) {
        pointsB += 1;
        updateB();
    }

    private void updateB() {
        viewB.setText(String.valueOf(pointsB));
    }

    public void resetGame(View view) {
        pointsA = 0;
        pointsB = 0;
        updateA();
        updateB();
    }
}