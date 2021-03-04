package com.example.trainingsplan.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface UebungenDAO {

    @Insert
    void addUebung(UebungenEntity uebungenEntity);

    @Delete
    void deleteUebung(UebungenEntity uebungenEntity);

    @Update
    void updateUebung(UebungenEntity uebungenEntity);


}
