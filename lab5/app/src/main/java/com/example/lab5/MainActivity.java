package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplayResult;
    private TextView tvCurrentOperation;
    private EditText inputField;

    private Double firstValue = null;
    private String currentOp = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayResult = findViewById(R.id.displayResult);
        tvCurrentOperation = findViewById(R.id.displayOperation);
        inputField = findViewById(R.id.editValue);

        setNumberListeners();
        setOperationListeners();
    }

    private void setNumberListeners() {
        int[] nums = {R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4,
                R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.bDot};

        for (int id : nums) {
            findViewById(id).setOnClickListener(v -> {
                Button b = (Button) v;
                appendToInput(b.getText().toString());
            });
        }
    }

    private void setOperationListeners() {
        int[] ops = {R.id.opAdd, R.id.opSub, R.id.opMul, R.id.opDiv, R.id.opEq};

        for (int id : ops) {
            findViewById(id).setOnClickListener(v -> {
                Button b = (Button) v;
                applyOperation(b.getText().toString());
            });
        }
    }

    private void appendToInput(String text) {
        if (currentOp.equals("=") && firstValue != null) {
            firstValue = null;
            inputField.setText("");
        }
        inputField.append(text);
    }

    private void applyOperation(String op) {
        String raw = inputField.getText().toString();

        if (!raw.isEmpty()) {
            String normalized = raw.replace(",", ".");
            try {
                compute(Double.parseDouble(normalized), op);
            } catch (Exception e) {
                inputField.setText("");
            }
        }

        currentOp = op;
        tvCurrentOperation.setText(op);
    }

    private void compute(double newValue, String operation) {
        if (firstValue == null) {
            firstValue = newValue;
        } else {
            switch (currentOp) {
                case "+":
                    firstValue += newValue;
                    break;
                case "-":
                    firstValue -= newValue;
                    break;
                case "*":
                    firstValue *= newValue;
                    break;
                case "/":
                    firstValue = (newValue == 0) ? 0 : firstValue / newValue;
                    break;
                case "=":
                    firstValue = newValue;
                    break;
            }
        }

        String formatted = String.valueOf(firstValue).replace(".", ",");
        tvDisplayResult.setText(formatted);
        inputField.setText("");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("curOp", currentOp);
        if (firstValue != null) outState.putDouble("firstVal", firstValue);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentOp = savedInstanceState.getString("curOp");
        firstValue = savedInstanceState.getDouble("firstVal");
        tvCurrentOperation.setText(currentOp);
        tvDisplayResult.setText(String.valueOf(firstValue));
    }
}