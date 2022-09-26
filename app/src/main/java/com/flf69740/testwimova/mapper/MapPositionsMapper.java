package com.flf69740.testwimova.mapper;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.testwimova.modele.MapPositions;

public class MapPositionsMapper {
    public MapPositions toMapPositions(BusinessMapPosition businessMapPosition){
        return new  MapPositions(
                businessMapPosition.getLatitude(),
                businessMapPosition.getLongitude()
        );
    }
}
