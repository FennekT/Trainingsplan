package com.example.trainingsplan.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

import java.io.Serializable;

/**
 * Entity fuer Trainigsplaene
 */
@Entity
public class TrainingsplanEntity implements Serializable {

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

    public Integer getTrainingsplanId() {
        return trainingsplanId;
    }

    public void setTrainingsplanId(Integer trainingsplanId) {
        this.trainingsplanId = trainingsplanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingsplanEntity that = (TrainingsplanEntity) o;
        return Objects.equals(trainingsplanId, that.trainingsplanId) &&
                Objects.equals(trainingsplanTitle, that.trainingsplanTitle) &&
                Objects.equals(trainingsplanDescription, that.trainingsplanDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingsplanId, trainingsplanTitle, trainingsplanDescription);
    }
}
