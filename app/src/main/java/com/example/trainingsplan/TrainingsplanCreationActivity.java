package com.example.trainingsplan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingsplan.database.TrainingsplanEntity;
import com.example.trainingsplan.database.TrainingsplanViewModel;

/**
 * Activity zur Erstellung eines Trainingsplans
 */
public class TrainingsplanCreationActivity extends AppCompatActivity {

    private TrainingsplanViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan_creation);
        setTitle("Erstelle einen Trainingsplan");

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);

        TextView editTitle = findViewById(R.id.editTitle);
        TextView editDescription = findViewById(R.id.editDescriptionText);

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(v -> {
            TrainingsplanEntity entity = new TrainingsplanEntity();
            entity.setTrainingsplanTitle( String.valueOf(editTitle.getText()));
            entity.setTrainingsplanDescription(String.valueOf(editDescription.getText()));
            vm.insertTrainingsplan(entity);
            finish();
        });
        Button abortButton = findViewById(R.id.abortButton);
        abortButton.setOnClickListener(v -> finish());
    }
}