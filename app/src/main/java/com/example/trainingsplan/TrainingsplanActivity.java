package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Activity welche alle existierenden Trainigsplaene anzeigt
 */
public class TrainingsplanActivity extends AppCompatActivity {

    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rv = findViewById(R.id.trainingsplanRecyclerView);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        TrainingsplanAdapter adapter = new TrainingsplanAdapter();
        rv.setAdapter(adapter);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        //aktuallisiert view wenn neuer plan erstellt wird
        vm.getTrainingsplanList().observe(this, adapter::submitList);

        Intent intent = new Intent(this, TrainingsplanCreationActivity.class);
        FloatingActionButton newTrainingsplanButton = findViewById(R.id.add_trainingsplan_btn);
        newTrainingsplanButton.setOnClickListener(v ->
                startActivity(intent));
        //TODO: Trainingsplan loeschbar machen

    }

}