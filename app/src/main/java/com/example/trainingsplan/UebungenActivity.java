package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UebungenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen);
        Intent intent = new Intent(this, UebungenCreationActivity.class);
        FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_btn3);
        addButton.setOnClickListener(v -> startActivity(intent));
    }
}