package com.flf69740.core.Modele;

public class BusinessSavedPosition {
    private String Date;
    private double latitude;
    private double longitude;

    public BusinessSavedPosition() {
    }

    public BusinessSavedPosition(String date, double latitude, double longitude) {
        Date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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
}
