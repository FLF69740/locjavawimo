package com.flf69740.datas.repository;

import android.content.Context;

import com.flf69740.datas.modele.DataPositions;

import io.reactivex.Single;

public interface DataMapPositionsRepository {
    Single<DataPositions> getDataMapPositions(Context context);
}
