package com.flf69740.core.repository;

import android.content.Context;

import com.flf69740.core.Modele.BusinessMapPosition;

import io.reactivex.Single;

public interface MapPositionsRepository {
    Single<BusinessMapPosition> getDataMapPositions(Context context);
}
