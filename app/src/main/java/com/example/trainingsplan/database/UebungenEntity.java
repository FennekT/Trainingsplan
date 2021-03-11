package com.example.trainingsplan.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class UebungenEntity implements Serializable {

    @PrimaryKey
    private Integer uebungId;

    @ColumnInfo
    private String uebungName;

    @ColumnInfo
    private Double uebungGewicht;

    @ColumnInfo
    private Integer uebungWiederholung;

    @ColumnInfo
    private boolean uebungOutdoor;

    public String getUebungName() {
        return uebungName;
    }

    public void setUebungName(String uebungName) {
        this.uebungName = uebungName;
    }

    public Double getUebungGewicht() {
        return uebungGewicht;
    }

    public void setUebungGewicht(Double uebungGewicht) {
        this.uebungGewicht = uebungGewicht;
    }

    public Integer getUebungWiederholung() {
        return uebungWiederholung;
    }

    public void setUebungWiederholung(Integer uebungWiederholung) {
        this.uebungWiederholung = uebungWiederholung;
    }

    public boolean isUebungOutdoor() {
        return uebungOutdoor;
    }

    public void setUebungOutdoor(boolean uebungOutdoor) {
        this.uebungOutdoor = uebungOutdoor;
    }

    public Integer getUebungId() {
        return uebungId;
    }

    public void setUebungId(Integer uebungId) {
        this.uebungId = uebungId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UebungenEntity that = (UebungenEntity) o;
        return uebungOutdoor == that.uebungOutdoor &&
                Objects.equals(uebungId, that.uebungId) &&
                Objects.equals(uebungName, that.uebungName) &&
                Objects.equals(uebungGewicht, that.uebungGewicht) &&
                Objects.equals(uebungWiederholung, that.uebungWiederholung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uebungId, uebungName, uebungGewicht, uebungWiederholung, uebungOutdoor);
    }
}
