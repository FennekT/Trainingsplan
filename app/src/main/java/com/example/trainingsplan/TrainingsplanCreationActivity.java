package com.example.trainingsplan;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingsplan.database.TrainingsplanEntity;
import com.example.trainingsplan.database.TrainingsplanViewModel;

public class TrainingsplanCreationActivity extends AppCompatActivity {

    private TrainingsplanViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan_creation);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);

        // TODO get Views um die Strings unten aus den Textfeldern holen zu können

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(v -> {
            TrainingsplanEntity entity = new TrainingsplanEntity();
            entity.setTrainingsplanTitle("IDK");
            entity.setTrainingsplanDescription("IDK");
            vm.insertTrainingsplan(entity);
            finish();
        });
        Button abortButton = findViewById(R.id.abortButton);
        abortButton.setOnClickListener(v -> finish());
    }
}