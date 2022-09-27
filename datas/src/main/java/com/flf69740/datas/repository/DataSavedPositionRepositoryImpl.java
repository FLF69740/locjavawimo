package com.flf69740.datas.repository;

import com.flf69740.datas.database.SavedPositionDao;
import com.flf69740.datas.modele.SavedPosition;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class DataSavedPositionRepositoryImpl implements DataSavedPositionRepository {

    private final SavedPositionDao savedPositionDao;

    @Inject
    DataSavedPositionRepositoryImpl(
            SavedPositionDao savedPositionDao
    ){
        this.savedPositionDao = savedPositionDao;
    }

    @Override
    public Single<List<SavedPosition>> getDataSavedPositions() {
        return savedPositionDao.getSavedPositions();
    }

    @Override
    public void createSavedPosition(SavedPosition position) {
        savedPositionDao.createSavedPosition(position);
    }
}
