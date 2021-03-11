package com.example.trainingsplan.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TrainingsplanViewModel extends AndroidViewModel {

    private final TrainingsplanDAO trainingsplanDAO;
    private final UebungenDAO uebungenDAO;
    private final LiveData<List<TrainingsplanWithUebungen>> allTrainingsplanList;

    public TrainingsplanViewModel(Application application) {
        super(application);
        TrainingsplanDatabase db = TrainingsplanDatabase.getInstance(application);
        trainingsplanDAO = db.getTrainingsplanDAO();
        allTrainingsplanList = trainingsplanDAO.getTrainingsplan();
        uebungenDAO = db.getUebungenDAO();
    }

    public LiveData<List<TrainingsplanWithUebungen>> getTrainingsplanList() {
        return allTrainingsplanList;
    }

    public void insertTrainingsplan(TrainingsplanEntity entity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> trainingsplanDAO.addTrainingsplan(entity));
    }

    public void insertUebung(UebungenEntity uebungenEntity) {
        uebungenDAO.addUebung(uebungenEntity);
    }
}
