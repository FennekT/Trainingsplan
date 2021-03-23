package com.example.trainingsplan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.util.StringUtil;

import com.example.trainingsplan.database.TrainingsplanEntity;
import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;

import java.io.Serializable;

/**
 * Activity zur Erstellung einer Uebung. Diese Activity oeffnet sich auch, wenn man eine
 * Uebung bearbeiten moechte.
 */
public class UebungenCreationActivity extends AppCompatActivity {
    private UebungenEntity uebungEntity;
    public static final String EXTRA_UEBUNG = "com.example.trainingsplan.UebungenCreationActivity.extra.Uebung";

    private TrainingsplanViewModel vm;
    private EditText gewichtView;
    private EditText titelView;
    private EditText wiederholungView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_creation);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        Button backButton = findViewById(R.id.backbtn);
        Button doneButton = findViewById(R.id.doneButton);
        gewichtView = findViewById(R.id.editGewicht);
        titelView = findViewById(R.id.editUebungTitel);
        wiederholungView = findViewById(R.id.editWiederholung);
        if (getIntent().getSerializableExtra(EXTRA_UEBUNG) != null) {
            setTitle("Bearbeite eine Übung");
            uebungEntity = (UebungenEntity) getIntent().getSerializableExtra(EXTRA_UEBUNG);
            gewichtView.setText(String.valueOf(uebungEntity.getUebungGewicht()));
            wiederholungView.setText(String.valueOf(uebungEntity.getUebungWiederholung()));
            titelView.setText(uebungEntity.getUebungName());

        } else {
            uebungEntity = new UebungenEntity();

        }
        backButton.setOnClickListener(v -> finish());
        doneButton.setOnClickListener(v -> onDone(uebungEntity));


    }

    private void onDone(UebungenEntity uebungenEntity) {
        try {
            uebungenEntity.setUebungName(String.valueOf(titelView.getText()));
            uebungenEntity.setUebungGewicht(Double.parseDouble(String.valueOf(gewichtView.getText())));
            uebungenEntity.setUebungWiederholung(Integer.parseInt(String.valueOf(wiederholungView.getText())));
        } catch (Exception e) {

            // TODO Hinweismeldung/Fehlertexte an die Inputs anhängen
            return;
        }

        if (uebungenEntity.getUebungId() != null) {
            vm.updateUebung(uebungenEntity);
        } else {
            vm.insertUebung(uebungenEntity);
        }
        finish();
    }

}