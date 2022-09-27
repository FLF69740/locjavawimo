package com.flf69740.core.usecases;

import com.flf69740.core.Modele.BusinessSavedPosition;

import java.util.List;

import io.reactivex.Single;

public interface GetSavedPositionsUseCase {
    Single<List<BusinessSavedPosition>> execute();
}
