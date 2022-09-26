package com.flf69740.datas.repository;

import android.content.Context;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.core.repository.MapPositionsRepository;
import com.flf69740.datas.mapper.BusinessMapPositionMapper;
import com.flf69740.datas.modele.DataPositions;
import com.flf69740.datas.repository.DataMapPositionsRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class MapPositionsRepositoryImpl implements MapPositionsRepository {

    private final DataMapPositionsRepository dataRepository;

    @Inject
    public MapPositionsRepositoryImpl(
        DataMapPositionsRepository dataRepository
    ){
        this.dataRepository = dataRepository;
    }

    @Override
    public Single<BusinessMapPosition> getDataMapPositions(Context context) {
        return dataRepository
                .getDataMapPositions(context)
                .flatMap((Function<DataPositions, Single<BusinessMapPosition>>) dataPositions ->
                    Single.just(
                        new BusinessMapPositionMapper()
                                .toBusinessMapPositions(dataPositions))
                );
    }
}
