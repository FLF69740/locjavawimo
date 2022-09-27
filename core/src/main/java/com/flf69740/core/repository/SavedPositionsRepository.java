package com.flf69740.core.repository;

import com.flf69740.core.Modele.BusinessSavedPosition;

import java.util.List;

import io.reactivex.Single;

public interface SavedPositionsRepository {
    Single<List<BusinessSavedPosition>> getSavedPositions();
    void createSavedPosition(BusinessSavedPosition savedPosition);
}
