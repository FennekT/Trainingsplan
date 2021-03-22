package com.example.trainingsplan.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Set;

@Dao
public interface UebungenDAO {

    @Insert
    void addUebung(UebungenEntity uebungenEntity);

    @Delete
    void deleteUebungen(Set<UebungenEntity> uebungenEntity);

    @Update
    void updateUebung(UebungenEntity uebungenEntity);

    @Query("SELECT * FROM UebungenEntity")
    LiveData<List<UebungenEntity>> getUebung();

    @Query("SELECT * FROM UebungenEntity INNER JOIN TrainingsplanUebungenCrossRefEntity as t " +
            "WHERE t.trainingsplanId = :trainingsplanId " +
            "GROUP BY t.uebungId")
    LiveData<List<UebungenEntity>> getUebungenForTrainingsplan(Integer trainingsplanId);

}
