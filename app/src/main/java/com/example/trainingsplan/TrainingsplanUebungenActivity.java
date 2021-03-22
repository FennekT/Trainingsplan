package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.TrainingsplanWithUebungen;
import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Set;

/**
 * Activity welche alle Uebungen des konkreten Trainingsplans beinhaltet
 */
public class TrainingsplanUebungenActivity extends AppCompatActivity {

    public static final String EXTRA_TRAININGSPLAN = "com.example.trainingsplan.UebungenActivity.extra.Trainingsplan";
    private TrainingsplanViewModel vm;
    private TrainingsplanUebungenAdapter adapter;
    private TrainingsplanWithUebungen openTrainingsplan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rv = findViewById(R.id.trainingsplanUebungenRecyclerView);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        adapter = new TrainingsplanUebungenAdapter();
        rv.setAdapter(adapter);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);

        openTrainingsplan = (TrainingsplanWithUebungen) getIntent().getSerializableExtra(EXTRA_TRAININGSPLAN);
        if (null != openTrainingsplan) {
            vm.getUebungenForTrainingsplan(openTrainingsplan).observe(this, adapter::submitList);
        }

//        //aktuallisiert view wenn neuer plan erstellt wird
//        vm.getUebung().observe(this, adapter::submitList);

        TrainingsplanWithUebungen openTrainingsplan = (TrainingsplanWithUebungen) getIntent().getSerializableExtra(EXTRA_TRAININGSPLAN);
        if (null != openTrainingsplan) {
            adapter.submitList(openTrainingsplan.uebungenEntities);

            FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_uebung_btn);
            addButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, UebungenOverviewActivity.class);
                intent.putExtra(UebungenOverviewActivity.EXTRA_TRAININGSPLAN, openTrainingsplan);
                startActivity(intent);
            });
        }

        //TODO: Uebung loeschbar machen
        //TODO Uebungen filtern im moment werden alle uebungen im Plan angezeit es sollen aber nur die sichtbar sein die in den Plan gehören
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
            vm.deleteUebungenFromTrainingsplan(openTrainingsplan.trainingsplanEntity, selectedEntities);
            selectedEntities.clear();
        }
        return super.onOptionsItemSelected(item);
    }
}