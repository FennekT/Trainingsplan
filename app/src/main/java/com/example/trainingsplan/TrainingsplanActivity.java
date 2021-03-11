package com.example.trainingsplan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TrainingsplanActivity extends AppCompatActivity {

    GridLayout gridLayout;
    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan);

        gridLayout = findViewById(R.id.layout);
        RecyclerView rv = findViewById(R.id.trainingsplanRecyclerView);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter();
        rv.setAdapter(adapter);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        vm.getTrainingsplanList().observe(this, adapter::submitList);

        Intent intent = new Intent(this, TrainingsplanCreationActivity.class);
        FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_btn);
        addButton.setOnClickListener(v -> startActivity(intent));
        //TODO: Trainingsplan loeschbar machen
        //TODO: CardView mit Entity verbinden
    }

}