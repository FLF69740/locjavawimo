package com.flf69740.core.intercators;

import com.flf69740.core.Modele.BusinessSavedPosition;
import com.flf69740.core.repository.SavedPositionsRepository;
import com.flf69740.core.usecases.GetSavedPositionsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class SavedPositionsInteractor implements
        GetSavedPositionsUseCase
{

    private final SavedPositionsRepository databaseRepository;

    @Inject
    SavedPositionsInteractor(
        SavedPositionsRepository databaseRepository
    ){
        this.databaseRepository = databaseRepository;
    }


    @Override
    public Single<List<BusinessSavedPosition>> execute() {
        return databaseRepository.getSavedPositions();
    }
}
