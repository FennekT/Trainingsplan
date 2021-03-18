package com.example.trainingsplan.database;

import androidx.room.Entity;

@Entity(primaryKeys = {"trainingsplanId", "uebungId"})
public class TrainingsplanUebungenCrossRefEntity {

    public int trainingsplanId;

    public int uebungId;

    public TrainingsplanUebungenCrossRefEntity(Integer trainingsplanId, Integer uebungId) {
        this.trainingsplanId = trainingsplanId;
        this.uebungId = uebungId;
    }

    public TrainingsplanUebungenCrossRefEntity() {
    }
}
