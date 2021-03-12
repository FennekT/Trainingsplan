package com.example.trainingsplan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingsplan.database.TrainingsplanEntity;
import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;

import java.io.Serializable;

public class UebungenCreationActivity extends AppCompatActivity {
  private  UebungenEntity uebungEntity;
    public static final String EXTRA_UEBUNG = "com.example.trainingsplan.UebungenCreationActivity.extra.Uebung";

    private TrainingsplanViewModel vm;
    private TextView gewichtView;
    private TextView titelView;
    private TextView wiederholungView;

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
        CheckBox outdoorCheckbox = findViewById(R.id.outdoorCheckbox);
        // TODO get Extra um eine ggf. Mitgegebene Übung zu öffnen und bearbeiten zu können
if ((UebungenEntity) getIntent().getSerializableExtra(EXTRA_UEBUNG)!=null){

     uebungEntity = (UebungenEntity) getIntent().getSerializableExtra(EXTRA_UEBUNG);
     //titelView.setText(uebungEntity.getUebungName());
}
else {
     uebungEntity = new UebungenEntity();

}
        gewichtView.setOnClickListener(v -> onGewicht(uebungEntity, gewichtView.getText().toString()));
        titelView.setOnClickListener(v -> onTitel(uebungEntity, String.valueOf(titelView.getText().toString())));
        wiederholungView.setOnClickListener(v -> onWiederholung(uebungEntity, wiederholungView.getText().toString()));
        outdoorCheckbox.setOnClickListener(v -> onOutdoor(uebungEntity, outdoorCheckbox.isChecked()));
        backButton.setOnClickListener(v -> finish());
        doneButton.setOnClickListener(v -> onDone(uebungEntity));


    }

    private void onDone(UebungenEntity uebungenEntity) {
        vm.insertUebung(uebungenEntity);
        finish();
    }

    private void onGewicht(UebungenEntity uebungenEntity, CharSequence gewicht) {
        uebungenEntity.setUebungGewicht(Double.parseDouble((String) gewicht));
    }

    private void onTitel(UebungenEntity uebungenEntity, String titel) {
        uebungenEntity.setUebungName(titel);
    }

    private void onWiederholung(UebungenEntity uebungenEntity, String wiederholung) {
        uebungenEntity.setUebungWiederholung(Integer.parseInt(wiederholung));
    }

    private void onOutdoor(UebungenEntity uebungenEntity, Boolean outDoor) {
        uebungenEntity.setUebungOutdoor(outDoor);
    }
}