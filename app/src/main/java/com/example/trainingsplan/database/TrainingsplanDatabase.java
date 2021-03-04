package com.example.trainingsplan.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version = 1, entities = {TrainingsplanEntity.class, UebungenEntity.class})
public abstract class TrainingsplanDatabase extends RoomDatabase {

    private static TrainingsplanDatabase INSTANCE;

    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(4);

    public static TrainingsplanDatabase getInstance(final Context context){
        if (null == INSTANCE){
            synchronized (TrainingsplanDatabase.class){
                INSTANCE = Room.databaseBuilder(context,TrainingsplanDatabase.class,"database")
                        .createFromAsset("database")
                        .build();
            }
        }
        return INSTANCE;
    }

    abstract public TrainingsplanDAO getTrainingsplanDAO();

    abstract public UebungenDAO getUebungenDAO();
}
