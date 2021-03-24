package com.example.trainingsplan.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Set;

/**
 * DAO fuer Uebungen
 */
@Dao
public interface UebungenDAO {

    @Insert
    void addUebung(UebungenEntity uebungenEntity);

    @Delete
    void deleteUebungen(Set<UebungenEntity> uebungenEntity);

    @Update
    void updateUebung(UebungenEntity uebungenEntity);

    @Query("SELECT * FROM UebungenEntity")
    LiveData<List<UebungenEntity>> getUebungen();

    @Query("SELECT * FROM UebungenEntity as u " +
            "INNER JOIN TrainingsplanUebungenCrossRefEntity as t on u.uebungId = t.uebungId " +
            "WHERE t.trainingsplanId = :trainingsplanId")
    LiveData<List<UebungenEntity>> getUebungenForTrainingsplan(Integer trainingsplanId);

}
