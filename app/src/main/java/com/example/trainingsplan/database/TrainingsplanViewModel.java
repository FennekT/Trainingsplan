package com.example.trainingsplan.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TrainingsplanViewModel extends AndroidViewModel {

    private final TrainingsplanDAO trainingsplanDAO;
    private final UebungenDAO uebungenDAO;
    private final LiveData<List<TrainingsplanWithUebungen>> allTrainingsplanList;
    private final LiveData<List<UebungenEntity>> uebungenListe;

    public TrainingsplanViewModel(Application application) {
        super(application);
        TrainingsplanDatabase db = TrainingsplanDatabase.getInstance(application);
        trainingsplanDAO = db.getTrainingsplanDAO();
        allTrainingsplanList = trainingsplanDAO.getTrainingsplan();
        uebungenDAO = db.getUebungenDAO();
        uebungenListe = uebungenDAO.getUebung();
    }

    public void insertTrainingsplan(TrainingsplanEntity entity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> trainingsplanDAO.addTrainingsplan(entity));
    }

    public LiveData<List<TrainingsplanWithUebungen>> getTrainingsplanList() {
        return allTrainingsplanList;
    }

    public void insertUebung(UebungenEntity uebungenEntity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> uebungenDAO.addUebung(uebungenEntity));
    }

    public LiveData<List<UebungenEntity>> getUebung() {
        return uebungenListe;
    }

    public void deleteUebung(UebungenEntity uebungenEntity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> uebungenDAO.deleteUebung(uebungenEntity));
    }
}
