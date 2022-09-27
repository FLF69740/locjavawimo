package com.flf69740.datas.repository;

import com.flf69740.core.Modele.BusinessSavedPosition;
import com.flf69740.core.repository.SavedPositionsRepository;
import com.flf69740.datas.mapper.BusinessSavedPositionsMapper;
import com.flf69740.datas.modele.SavedPosition;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class SavedPositionsRepositoryImpl implements SavedPositionsRepository {

    private final DataSavedPositionRepository dataSavedPositionRepository;

    @Inject
    public SavedPositionsRepositoryImpl(
        DataSavedPositionRepository dataSavedPositionRepository
    ){
        this.dataSavedPositionRepository = dataSavedPositionRepository;
    }

    @Override
    public Single<List<BusinessSavedPosition>> getSavedPositions() {
        return dataSavedPositionRepository
                .getDataSavedPositions()
                .flatMap((Function<List<SavedPosition>, Single<List<BusinessSavedPosition>>>) savedPositions ->
                        Single.just(
                                new BusinessSavedPositionsMapper().toBusinessSavedPositions(savedPositions))
               );
    }

    @Override
    public void createSavedPosition(BusinessSavedPosition savedPosition) {
        dataSavedPositionRepository.createSavedPosition(new BusinessSavedPositionsMapper().toDataSavedPosition(savedPosition));
    }
}
