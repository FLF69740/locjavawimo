package com.flf69740.core.intercators;

import android.annotation.SuppressLint;
import android.content.Context;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.core.Modele.BusinessSavedPosition;
import com.flf69740.core.repository.MapPositionsRepository;
import com.flf69740.core.repository.SavedPositionsRepository;
import com.flf69740.core.usecases.GetMapPositionsUseCase;
import javax.inject.Inject;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class MapPositionsInteractor implements GetMapPositionsUseCase {

    private final MapPositionsRepository repository;
    private final SavedPositionsRepository databaseRepository;

    @Inject
    MapPositionsInteractor(
        MapPositionsRepository repository,
        SavedPositionsRepository databaseRepository
    ){
        this.repository = repository;
        this.databaseRepository = databaseRepository;
    }


    @SuppressLint("CheckResult")
    @Override
    public Single<BusinessMapPosition> execute(Context context, String date) {
        Single<BusinessMapPosition> result = repository
                .getDataMapPositions(context)
                .map(getBusinessToDatabase(date));
        return result;
    }

    private Function<BusinessMapPosition, BusinessMapPosition> getBusinessToDatabase(String date){
        return mapPosition -> {
            databaseRepository.createSavedPosition(
                    new BusinessSavedPosition(
                            date,
                            mapPosition.getLatitude(),
                            mapPosition.getLongitude()
                    )
            );
            return mapPosition;
        };
    }
}
