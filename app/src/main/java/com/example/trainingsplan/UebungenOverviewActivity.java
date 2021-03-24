package com.example.trainingsplan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.TrainingsplanWithUebungen;
import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Overview welche alle existierenden Uebungen anzeigt. Von hier aus koennen per Longclick die
 * einzelnen Uebungen auch bearbeitet werden.
 */
public class UebungenOverviewActivity extends AppCompatActivity implements Serializable {

    public static final String EXTRA_TRAININGSPLAN = "com.example.trainingsplan.UebungenOverviewActivity.extra.Trainingsplan";

    private TrainingsplanViewModel vm;
    private TrainingsplanUebungenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_overview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton createUebung = findViewById(R.id.add_uebung_btn2);
        createUebung.setOnClickListener(v -> {
            Intent intent = new Intent(this, UebungenCreationActivity.class);
            startActivity(intent);
        });

        RecyclerView rv = findViewById(R.id.trainingsplanRecyclerViewOverview);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        adapter = new TrainingsplanUebungenAdapter();
        rv.setAdapter(adapter);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        //aktuallisiert view wenn neuer plan erstellt wird
        vm.getUebungen().observe(this, adapter::submitList);

        TrainingsplanWithUebungen openTrainingsplan = (TrainingsplanWithUebungen) getIntent().getSerializableExtra(EXTRA_TRAININGSPLAN);

        if (null != openTrainingsplan) {
            FloatingActionButton add = findViewById(R.id.add_uebung_to_trainingsplan_btn);
            add.setOnClickListener(v -> {
                Set<UebungenEntity> selectedEntities = adapter.getSelectedEntities();
                openTrainingsplan.uebungenEntities.addAll(selectedEntities);
                vm.insertTrainingsplanWithUebungen(openTrainingsplan);
                selectedEntities.clear();
                finish();
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trainingsplan_uebungen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.delete) {
            Set<UebungenEntity> selectedEntities = adapter.getSelectedEntities();
            vm.deleteUebungen(new HashSet<>(selectedEntities));
            selectedEntities.clear();
        }
        return super.onOptionsItemSelected(item);
    }
}