package com.flf69740.datas.repository;

import android.content.Context;
import android.location.Location;

import com.flf69740.datas.service.GPSTracker;
import com.flf69740.datas.modele.DataPositions;

import javax.inject.Inject;

import io.reactivex.Single;

public class DataMapPositionsRepositoryImpl implements DataMapPositionsRepository {

    @Inject
    DataMapPositionsRepositoryImpl(){}

    public Single<DataPositions> getDataMapPositions(Context context) {
        GPSTracker tracker = new GPSTracker();
        Location location = tracker.getLocation(context);
        return location == null ?
                Single.just(new DataPositions(0.0, 0.0)) :
                Single.just(new DataPositions(location.getLatitude(), location.getLongitude()));
    }
}
