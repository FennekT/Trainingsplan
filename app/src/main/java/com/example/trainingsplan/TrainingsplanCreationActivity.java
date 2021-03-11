package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trainingsplan.database.TrainingsplanDatabase;
import com.example.trainingsplan.database.TrainingsplanEntity;

public class TrainingsplanCreationActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan_creation);
        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(v -> TrainingsplanDatabase.getInstance(v.getContext())
                .getTrainingsplanDAO()
                .addTrainingsplan(new TrainingsplanEntity()));
        Button abortButton = findViewById(R.id.abortButton);
        abortButton.setOnClickListener(v -> finish());
    }
}