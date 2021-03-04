package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trainingsplan.database.TrainingsplanDatabase;
import com.example.trainingsplan.database.TrainingsplanEntity;

public class CreateTrainingsplanActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trainingsplan);
        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(this::onClick);
        Button abortButton = findViewById(R.id.abortButton);
        abortButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        //Trainingsplan erstellen wenn Button Erstellen gedrueckt wird
        if (v.getId() == R.id.createButton){
            TrainingsplanDatabase.getInstance(v.getContext())
                    .getTrainingsplanDAO()
                    .addTrainingsplan(new TrainingsplanEntity());
        }
        //Activity wieder schliessen wenn Button Abbrechen gedrueckt wird
        if (v.getId() == R.id.abortButton){
            setContentView(R.layout.activity_trainingsplan);
        }
    }
}