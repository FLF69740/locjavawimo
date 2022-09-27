package com.flf69740.testwimova.di;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.flf69740.datas.database.SavedPositionDao;
import com.flf69740.datas.database.SavedPositionsDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class AppModule {

    @Singleton
    @Provides
    SavedPositionsDatabase provideMyDatabase(
            @ApplicationContext Context context
    ) {
        return Room.databaseBuilder(
                context,
                SavedPositionsDatabase.class,
                "MyDatabase.db"
        ).build();
    }

    @Singleton
    @Provides
    SavedPositionDao provideMyDao(@NonNull SavedPositionsDatabase database) {
        return database.savedPositionDao();
    }

}
