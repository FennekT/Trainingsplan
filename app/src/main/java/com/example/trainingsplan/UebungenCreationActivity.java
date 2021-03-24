package com.example.trainingsplan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;

/**
 * Activity zur Erstellung einer Uebung. Diese Activity oeffnet sich auch, wenn man eine
 * Uebung bearbeiten moechte.
 */
public class UebungenCreationActivity extends AppCompatActivity {
    private UebungenEntity uebungEntity;
    public static final String EXTRA_UEBUNG = "com.example.trainingsplan.UebungenCreationActivity.extra.Uebung";

    private TrainingsplanViewModel vm;
    private EditText weightView;
    private EditText titleView;
    private EditText repetitionsView;
    private String errorString = "Bitte ausfüllen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_creation);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        Button backButton = findViewById(R.id.backbtn);
        Button doneButton = findViewById(R.id.doneButton);
        weightView = findViewById(R.id.editGewicht);
        titleView = findViewById(R.id.editUebungTitel);
        repetitionsView = findViewById(R.id.editWiederholung);
        if (getIntent().getSerializableExtra(EXTRA_UEBUNG) != null) {
            setTitle("Bearbeite eine Übung");
            uebungEntity = (UebungenEntity) getIntent().getSerializableExtra(EXTRA_UEBUNG);
            weightView.setText(String.valueOf(uebungEntity.getUebungGewicht()));
            repetitionsView.setText(String.valueOf(uebungEntity.getUebungWiederholung()));
            titleView.setText(uebungEntity.getUebungName());

        } else {
            uebungEntity = new UebungenEntity();

        }
        backButton.setOnClickListener(v -> finish());
        doneButton.setOnClickListener(v -> onDone(uebungEntity));


    }

    private void onDone(UebungenEntity uebungenEntity) {
        try {
            uebungenEntity.setUebungName(String.valueOf(titleView.getText()));
            uebungenEntity.setUebungGewicht(Double.parseDouble(String.valueOf(weightView.getText())));
            uebungenEntity.setUebungWiederholung(Integer.parseInt(String.valueOf(repetitionsView.getText())));
        } catch (Exception e) {

            if (weightView.length() == 0) {
                weightView.setError(errorString);
            }
            if (titleView.length() == 0) {
                titleView.setError(errorString);
            }
            if (repetitionsView.length() == 0) {
                repetitionsView.setError(errorString);
            }
            return;
        }
        //wenn ID zur Uebung bereits vorhanden, dann soll die Uebung geupdated werden
        if (uebungenEntity.getUebungId() != null) {
            vm.updateUebung(uebungenEntity);
        //andernfalls soll eine neue Uebung erstellt werden
        } else {
            vm.insertUebung(uebungenEntity);
        }
        finish();
    }

}