package com.example.trainingsplan.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
interface TrainingsplanDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrainingsplan(TrainingsplanEntity trainingsplanEntity);

    @Delete
    void deleteTrainingsplan(TrainingsplanEntity trainingsplanEntity);

    @Query("SELECT * FROM TrainingsplanEntity")
    LiveData<List<TrainingsplanEntity>> getTrainingsplan();

    @Query("SELECT * FROM TrainingsplanEntity")
    LiveData<List<TrainingsplanWithUebungen>> getTrainingsplanWithUebungen();

}
