package com.example.trainingsplan.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;


@Dao
interface TrainingsplanDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrainingsplan(TrainingsplanEntity trainingsplanEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void connectUebungen(List<TrainingsplanUebungenCrossRefEntity> connectedUebungen);

    @Delete
    void deleteTrainingsplan(List<TrainingsplanUebungenCrossRefEntity> connectedUebungen);

    @Transaction
    @Query("SELECT * FROM TrainingsplanEntity")
    LiveData<List<TrainingsplanWithUebungen>> getTrainingsplan();

    @Transaction
    @Query("SELECT * FROM TrainingsplanEntity")
    LiveData<List<TrainingsplanWithUebungen>> getTrainingsplanWithUebungen();
}
