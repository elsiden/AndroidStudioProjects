package com.example.bd5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText keySet;
    private EditText valueSet;
    private EditText keyGet;
    private EditText valueGet;
    private Button saveBtn;
    private Button getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = findViewById(R.id.saveBtn);
        getBtn = findViewById(R.id.getBtn);

        saveBtn.setOnClickListener(v -> {

        });

        getBtn.setOnClickListener(v -> {

        });
    }
}