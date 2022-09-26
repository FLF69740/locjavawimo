package com.flf69740.core.Modele;

public class BusinessMapPosition {
    private Double latitude;
    private Double longitude;

    public BusinessMapPosition() {
    }

    public BusinessMapPosition(Double latitude, Double longitude) {
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
}
