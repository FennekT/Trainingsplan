package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class UebungenOverviewActivity extends AppCompatActivity implements Serializable {
    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_overview);
        FloatingActionButton addUebung = findViewById(R.id.add_uebung_btn2);
        FloatingActionButton add = findViewById(R.id.floatingActionButton);
        Intent intent = new Intent(this, UebungenCreationActivity.class);
        intent.putExtra(UebungenCreationActivity.EXTRA_UEBUNG, new UebungenEntity());
        addUebung.setOnClickListener(v -> startActivity(intent));

        RecyclerView rv = findViewById(R.id.trainingsplanRecyclerViewOverview);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        TrainingsplanUebungenAdapter adapter = new TrainingsplanUebungenAdapter();
        rv.setAdapter(adapter);


        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        //aktuallisiert view wenn neuer plan erstellt wird
        vm.getUebung().observe(this, adapter::submitList);

    }



}