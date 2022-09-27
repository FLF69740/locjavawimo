package com.flf69740.datas.repository;

import com.flf69740.datas.modele.SavedPosition;

import java.util.List;

import io.reactivex.Single;

public interface DataSavedPositionRepository {
    Single<List<SavedPosition>> getDataSavedPositions();
    void createSavedPosition(SavedPosition position);
}
