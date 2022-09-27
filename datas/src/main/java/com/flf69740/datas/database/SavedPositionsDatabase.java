package com.flf69740.datas.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.flf69740.datas.modele.SavedPosition;

@Database(entities = {SavedPosition.class}, version = 1, exportSchema = false)
public abstract class SavedPositionsDatabase extends RoomDatabase {
    // DAO
    public abstract SavedPositionDao savedPositionDao();
}
