package com.example.trainingsplan;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {TrainingsplanEntity.class, UebungenEntity.class})
public abstract class TrainingsplanDatabase extends RoomDatabase {

    abstract public TrainingsplanDAO getTrainingsplanDAO();

    abstract public UebungenDAO getUebungenDAO();
}
