package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UebungenActivity extends AppCompatActivity {

    public static final String extraString = "neueUebung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen);
        Intent intent = new Intent(this, UebungenCreationActivity.class);
        intent.putExtra(extraString, new UebungenEntity());
        FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_btn3);
        addButton.setOnClickListener(v -> startActivity(intent));
    }
}