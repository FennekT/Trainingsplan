package com.example.trainingsplan.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TrainingsplanViewModel extends AndroidViewModel {

    private final TrainingsplanDAO trainingsplanDAO;
    private final LiveData<List<TrainingsplanEntity>> allTrainingsplanList;

    public TrainingsplanViewModel(Application application) {
        super(application);
        TrainingsplanDatabase db = TrainingsplanDatabase.getInstance(application);
        trainingsplanDAO = db.getTrainingsplanDAO();
        allTrainingsplanList = trainingsplanDAO.getTrainingsplan();
    }

    public LiveData<List<TrainingsplanEntity>> getTrainingsplanList() {
        return allTrainingsplanList;
    }

    public void insertTrainingsplan(TrainingsplanEntity entity) {
        TrainingsplanDatabase.databaseExecutor.execute(() -> trainingsplanDAO.addTrainingsplan(entity));
    }
}
