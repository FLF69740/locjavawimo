package com.flf69740.core.intercators;

import android.content.Context;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.core.repository.MapPositionsRepository;
import com.flf69740.core.usecases.GetMapPositionsUseCase;

import javax.inject.Inject;

import io.reactivex.Single;

public class MapPositionsInteractor implements GetMapPositionsUseCase {

    private final MapPositionsRepository repository;

    @Inject
    MapPositionsInteractor(
        MapPositionsRepository repository
    ){
        this.repository = repository;
    }


    @Override
    public Single<BusinessMapPosition> execute(Context context) {
        return repository.getDataMapPositions(context);
    }
}
