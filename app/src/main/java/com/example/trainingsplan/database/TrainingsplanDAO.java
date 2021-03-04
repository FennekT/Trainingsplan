package com.example.trainingsplan.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.trainingsplan.database.TrainingsplanEntity;

import java.util.List;


@Dao
public interface TrainingsplanDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrainingsplan(TrainingsplanEntity trainingsplanEntity);

    @Delete
    void deleteTrainingsplan(TrainingsplanEntity trainingsplanEntity);

    @Transaction
    @Query("SELECT * FROM TrainingsplanEntity")
    List<TrainingsplanEntity> getTrainingsplanWithUebungen();
}
