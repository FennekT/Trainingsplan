package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.TrainingsplanWithUebungen;
import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.Set;

/**
 * Overview welche alle existierenden Uebungen anzeigt. Von hier aus koennen per Longclick die
 * einzelnen Uebungen auch bearbeitet werden.
 */
public class UebungenOverviewActivity extends AppCompatActivity implements Serializable {

    public static final String EXTRA_TRAININGSPLAN = "com.example.trainingsplan.UebungenOverviewActivity.extra.Trainingsplan";

    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_overview);
        FloatingActionButton createUebung = findViewById(R.id.add_uebung_btn2);
        setTitle("Alle Übungen");

        createUebung.setOnClickListener(v -> {
            Intent intent = new Intent(this, UebungenCreationActivity.class);
            startActivity(intent);
        });

        RecyclerView rv = findViewById(R.id.trainingsplanRecyclerViewOverview);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        TrainingsplanUebungenAdapter adapter = new TrainingsplanUebungenAdapter();
        rv.setAdapter(adapter);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        //aktuallisiert view wenn neuer plan erstellt wird
        vm.getUebung().observe(this, adapter::submitList);


        TrainingsplanWithUebungen openTrainingsplan = (TrainingsplanWithUebungen) getIntent().getSerializableExtra(EXTRA_TRAININGSPLAN);
        if (null != openTrainingsplan) {

            FloatingActionButton delete = findViewById(R.id.floatingActionButton2);
            delete.setOnClickListener(v -> {
                adapter.submitList(openTrainingsplan.uebungenEntities);
                Set<UebungenEntity> selectedEntities = adapter.getSelectedEntities();
                openTrainingsplan.uebungenEntities.addAll(selectedEntities);
                vm.deleteUebungen(selectedEntities);
                selectedEntities.clear();
            });

            TrainingsplanWithUebungen openTrainingsplan2 = (TrainingsplanWithUebungen) getIntent().getSerializableExtra(EXTRA_TRAININGSPLAN);

            if (null != openTrainingsplan2) {

            FloatingActionButton add = findViewById(R.id.floatingActionButton);
                add.setOnClickListener(v -> {
                    adapter.submitList(openTrainingsplan2.uebungenEntities);
                    Set<UebungenEntity> selectedEntities = adapter.getSelectedEntities();
                openTrainingsplan2.uebungenEntities.addAll(selectedEntities);
                vm.insertTrainingsplanWithUebungen(openTrainingsplan2);
                selectedEntities.clear();
                finish();
            });
        }


    }


}}