package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class UebungenOverviewActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_overview);
        FloatingActionButton addUebung = findViewById(R.id.add_uebung_btn2);
        Intent intent = new Intent(this, UebungenCreationActivity.class);
        intent.putExtra(UebungenCreationActivity.EXTRA_UEBUNG, new UebungenEntity());
        addUebung.setOnClickListener(v -> startActivity(intent));
    }



}