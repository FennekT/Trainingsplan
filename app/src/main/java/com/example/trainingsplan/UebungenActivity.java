package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
        Intent neueUebungIntent = new Intent(this,UebungenOverviewActivity.class);
        Button uebungHinzufuegen = findViewById(R.id.uebungHinzufuegen);
        uebungHinzufuegen.setOnClickListener(v -> startActivity(neueUebungIntent));
    }

    //TODO: Uebung loeschbar machen
    //TODO: CardView einbauen welchen die Uebungen anzeigt
}