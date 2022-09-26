package com.flf69740.datas.service;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class GPSTracker extends Service implements LocationListener {

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    private Location mLocation;

    public GPSTracker(){}

    @SuppressLint("MissingPermission")
    public Location getLocation(Context context) {
        try{
            LocationManager mLocationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            boolean isGPSEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (ContextCompat.checkSelfPermission(context, FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(context, COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){

                if (isGPSEnabled){
                    if (mLocation == null){
                        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
                        mLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    }
                }

                if (mLocation == null) {
                    if (isNetworkEnabled){
                        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 10, this);
                        mLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    }
                }
            }

        } catch (Exception ex){
            Log.e("ERROR", ex.getMessage());
        }

        return mLocation;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
