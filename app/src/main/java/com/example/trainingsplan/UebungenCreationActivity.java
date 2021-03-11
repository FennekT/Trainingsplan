package com.example.trainingsplan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;

public class UebungenCreationActivity extends AppCompatActivity {

    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_creation);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);

        Button doneButton = findViewById(R.id.doneButton);
        TextView gewichtView = findViewById(R.id.editGewicht);
        TextView titelView = findViewById(R.id.editUebungTitel);
        TextView wiederholungView = findViewById(R.id.editWiederholung);

        UebungenEntity uebungEntity = (UebungenEntity) getIntent().getSerializableExtra(UebungenActivity.extraString);
        doneButton.setOnClickListener(v -> onDone(uebungEntity));
        gewichtView.setOnClickListener(v -> onGewicht(uebungEntity,gewichtView.getText()));
        titelView.setOnClickListener(v -> onTitel(uebungEntity, String.valueOf(gewichtView.getText())));
        wiederholungView.setOnClickListener(v -> onWiederholung(uebungEntity,gewichtView.getText()));

    }

    private void onDone(UebungenEntity uebungenEntity){
        vm.insertUebung(uebungenEntity);
        finish();
    }

    private void onGewicht(UebungenEntity uebungenEntity, CharSequence gewicht){
        uebungenEntity.setUebungGewicht(Double.parseDouble((String) gewicht));
    }

    private void onTitel(UebungenEntity uebungenEntity, String titel){
        uebungenEntity.setUebungName(titel);
    }

    private void onWiederholung(UebungenEntity uebungenEntity, CharSequence wiederholung){
        uebungenEntity.setUebungWiederholung(Integer.parseInt((String) wiederholung));
    }
}