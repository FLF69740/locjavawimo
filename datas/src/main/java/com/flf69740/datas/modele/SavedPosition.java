package com.flf69740.datas.modele;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SavedPosition {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private double latitude;
    private double longitude;
    private String date;

    public SavedPosition() {
    }

    public SavedPosition(double latitude, double longitude, String date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
