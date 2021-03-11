package com.example.trainingsplan;

import android.app.Service;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.trainingsplan.database.TrainingsplanDatabase;
import com.example.trainingsplan.database.UebungenEntity;

import androidx.appcompat.app.AppCompatActivity;

public class UebungenCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungen_creation);
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
        TrainingsplanDatabase.getInstance(this).getUebungenDAO().updateUebung(uebungenEntity);
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