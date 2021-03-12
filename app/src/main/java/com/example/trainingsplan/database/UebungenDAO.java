package com.example.trainingsplan.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UebungenDAO {

    @Insert
    void addUebung(UebungenEntity uebungenEntity);

    @Delete
    void deleteUebung(UebungenEntity uebungenEntity);

    @Update
    void updateUebung(UebungenEntity uebungenEntity);

    @Query("SELECT * FROM UebungenEntity")
    LiveData<List<UebungenEntity>> getUebung();

}
