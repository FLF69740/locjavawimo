package com.flf69740.testwimova.modele;

import javax.annotation.Nullable;

public class MapPositions {
    private Double latitude;
    private Double longitude;
    private String date;

    public MapPositions() {
    }

    public MapPositions(@Nullable String date, Double latitude, Double longitude) {
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
