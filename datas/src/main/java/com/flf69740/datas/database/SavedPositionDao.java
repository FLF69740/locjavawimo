package com.flf69740.datas.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.flf69740.datas.modele.SavedPosition;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface SavedPositionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createSavedPosition(SavedPosition position);

    @Query("SELECT * FROM SavedPosition")
    Single<List<SavedPosition>> getSavedPositions();
}
