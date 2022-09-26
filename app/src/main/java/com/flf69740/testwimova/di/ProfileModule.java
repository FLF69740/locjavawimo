package com.flf69740.testwimova.di;


import com.flf69740.core.usecases.GetMapPositionsUseCase;
import com.flf69740.core.intercators.MapPositionsInteractor;
import com.flf69740.core.repository.MapPositionsRepository;
import com.flf69740.datas.repository.DataMapPositionsRepository;
import com.flf69740.datas.repository.DataMapPositionsRepositoryImpl;
import com.flf69740.datas.repository.MapPositionsRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@InstallIn(ViewModelComponent.class)
@Module
abstract public class ProfileModule {

    @Binds
    abstract DataMapPositionsRepository getCommonGreeting(DataMapPositionsRepositoryImpl repository);

    @Binds
    abstract MapPositionsRepository getGreeting(MapPositionsRepositoryImpl repository);

    @Binds
    abstract GetMapPositionsUseCase greetingInteractor(MapPositionsInteractor greetingUseCase);

}
