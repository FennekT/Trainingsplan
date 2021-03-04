package com.example.trainingsplan.database;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class TrainingsplanWithUebungen {
    @Embedded
    public TrainingsplanEntity trainingsplanEntity;

    @Relation(
            parentColumn = "trainingsplanId",
            entityColumn = "uebungId",
            associateBy = @Junction(TrainingsplanUebungenCrossRefEntity.class)
    )
    public List<UebungenEntity> trainingsplanEntities;
}
