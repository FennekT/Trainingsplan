package com.example.trainingsplan.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Vereinfacht Datenbankzugriff
 */
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
        uebungenListe = uebungenDAO.getUebungen();
    }

    public void insertTrainingsplan(TrainingsplanEntity entity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> trainingsplanDAO.addTrainingsplan(entity));
    }

    public void insertTrainingsplanWithUebungen(TrainingsplanWithUebungen pojo) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> {
            trainingsplanDAO.addTrainingsplan(pojo.trainingsplanEntity);
            List<TrainingsplanUebungenCrossRefEntity> trainingsplanUebungenCrossRefEntities = pojo.uebungenEntities.stream()
                    .map(uebungenEntity -> new TrainingsplanUebungenCrossRefEntity(pojo.trainingsplanEntity.getTrainingsplanId(), uebungenEntity.getUebungId()))
                    .collect(Collectors.toList());
            trainingsplanDAO.connectUebungen(trainingsplanUebungenCrossRefEntities);
        });
    }

    public void deleteUebungenFromTrainingsplan(TrainingsplanEntity trainingsplan, Set<UebungenEntity> toDisconnect) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> {
            List<TrainingsplanUebungenCrossRefEntity> trainingsplanUebungenCrossRefEntities = toDisconnect.stream()
                    .map(uebungenEntity -> new TrainingsplanUebungenCrossRefEntity(trainingsplan.getTrainingsplanId(), uebungenEntity.getUebungId()))
                    .collect(Collectors.toList());
            trainingsplanDAO.deleteUebungenFromTrainingsplan(trainingsplanUebungenCrossRefEntities);
        });
    }

    public void deleteUebungen(Set<UebungenEntity> set) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> {
            uebungenDAO.deleteUebungen(set);
        });
    }

    public LiveData<List<TrainingsplanWithUebungen>> getTrainingsplanList() {
        return allTrainingsplanList;
    }

    public void insertUebung(UebungenEntity uebungenEntity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> uebungenDAO.addUebung(uebungenEntity));
    }

    public void updateUebung(UebungenEntity uebungenEntity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> uebungenDAO.updateUebung(uebungenEntity));
    }

    public LiveData<List<UebungenEntity>> getUebungen() {
        return uebungenListe;
    }


    public LiveData<List<UebungenEntity>> getUebungenForTrainingsplan(TrainingsplanWithUebungen openTrainingsplan) {
        return uebungenDAO.getUebungenForTrainingsplan(openTrainingsplan.trainingsplanEntity.getTrainingsplanId());
    }
}
