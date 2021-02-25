package com.example.trainingsplan;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class TrainingsplanEntity {

    @PrimaryKey
    private int trainingsplanId;

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
