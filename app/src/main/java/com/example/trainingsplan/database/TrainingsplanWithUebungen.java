package com.example.trainingsplan.database;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TrainingsplanWithUebungen implements Serializable {
    @Embedded
    public TrainingsplanEntity trainingsplanEntity;

    @Relation(
            parentColumn = "trainingsplanId",
            entityColumn = "uebungId",
            associateBy = @Junction(TrainingsplanUebungenCrossRefEntity.class)
    )
    public List<UebungenEntity> uebungenEntities;
}
