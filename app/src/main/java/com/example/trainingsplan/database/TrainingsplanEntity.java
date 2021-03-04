package com.example.trainingsplan.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TrainingsplanEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer trainingsplanId;

    @ColumnInfo
    private String trainingsplanTitle;

    @ColumnInfo
    private String trainingsplanDescription;

    public String getTrainingsplanTitle() {
        return trainingsplanTitle;
    }

    public void setTrainingsplanTitle(String trainingsplanTitle) {
        this.trainingsplanTitle = trainingsplanTitle;
    }

    public String getTrainingsplanDescription() {
        return trainingsplanDescription;
    }

    public void setTrainingsplanDescription(String trainingsplanDescription) {
        this.trainingsplanDescription = trainingsplanDescription;
    }
}
