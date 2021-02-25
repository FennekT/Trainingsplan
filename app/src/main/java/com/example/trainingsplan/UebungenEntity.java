package com.example.trainingsplan;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UebungenEntity {

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
}
