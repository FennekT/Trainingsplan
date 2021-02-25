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
}
