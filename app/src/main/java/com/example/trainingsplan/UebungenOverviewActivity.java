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

public class UebungenOverviewActivity extends AppCompatActivity implements Serializable {

    public static final String EXTRA_TRAININGSPLAN = "com.example.trainingsplan.UebungenOverviewActivity.extra.Trainingsplan";

    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_overview);
        FloatingActionButton createUebung = findViewById(R.id.add_uebung_btn2);

        createUebung.setOnClickListener(v -> {
            Intent intent = new Intent(this, UebungenCreationActivity.class);
            intent.putExtra(UebungenCreationActivity.EXTRA_UEBUNG, new UebungenEntity());
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
            adapter.submitList(openTrainingsplan.uebungenEntities);
            FloatingActionButton delete = findViewById(R.id.floatingActionButton2);
            delete.setOnClickListener(v -> {
                Set<UebungenEntity> selectedEntities = adapter.getSelectedEntities();
                openTrainingsplan.uebungenEntities.addAll(selectedEntities);
                vm.deleteUebungen(selectedEntities);
            });
        if (null != openTrainingsplan) {
            adapter.submitList(openTrainingsplan.uebungenEntities);
            FloatingActionButton add = findViewById(R.id.floatingActionButton);
            add.setOnClickListener(v -> {
                Set<UebungenEntity> selectedEntities = adapter.getSelectedEntities();
                openTrainingsplan.uebungenEntities.addAll(selectedEntities);
                vm.insertTrainingsplanWithUebungen(openTrainingsplan);
                finish();
            });
        }


    }


}}