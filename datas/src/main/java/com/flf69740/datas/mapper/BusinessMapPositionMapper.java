package com.flf69740.datas.mapper;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.datas.modele.DataPositions;

public class BusinessMapPositionMapper {
    public BusinessMapPosition toBusinessMapPositions(DataPositions positions){
        return new BusinessMapPosition(
                positions.getLatitude(),
                positions.getLongitude()
        );
    }
}
