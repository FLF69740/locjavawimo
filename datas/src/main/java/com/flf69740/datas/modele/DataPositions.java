package com.flf69740.datas.modele;

public class DataPositions {
    private Double latitude;
    private Double longitude;

    public DataPositions() {
    }

    public DataPositions(Double posX, Double longitude) {
        this.latitude = posX;
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
