package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanEntity;
import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.TrainingsplanWithUebungen;
import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UebungenActivity extends AppCompatActivity {

    public static final String EXTRA_TRAININGSPLAN = "com.example.trainingsplan.UebungenActivity.extra.Trainingsplan";
    public static final String extraString = "neueUebung";
    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen);

        RecyclerView rv = findViewById(R.id.trainingsplanUebungenRecyclerView);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        TrainingsplanUebungenAdapter adapter = new TrainingsplanUebungenAdapter();
        rv.setAdapter(adapter);

     /*   TrainingsplanWithUebungen extra = (TrainingsplanWithUebungen) getIntent().getSerializableExtra(EXTRA_TRAININGSPLAN);
        if (null != extra) {
            adapter.submitList(extra.trainingsplanEntities);
        }


      */
        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        //aktuallisiert view wenn neuer plan erstellt wird
        vm.getUebung().observe(this, adapter::submitList);

        FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_uebung_btn);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, UebungenOverviewActivity.class);
            startActivity(intent);
        });
    }

    //TODO: Uebung loeschbar machen
    //TODO Uebungen filtern im moment werden alle uebungen im Plan angezeit es sollen aber nur die sichtbar sein die in den Plan gehören
}