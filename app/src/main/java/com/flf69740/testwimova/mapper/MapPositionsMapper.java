package com.flf69740.testwimova.mapper;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.core.Modele.BusinessSavedPosition;
import com.flf69740.testwimova.modele.MapPositions;

import java.util.ArrayList;
import java.util.List;

public class MapPositionsMapper {
    public MapPositions toMapPositions(BusinessMapPosition businessMapPosition){
        return new  MapPositions(
                null,
                businessMapPosition.getLatitude(),
                businessMapPosition.getLongitude()
        );
    }

    public List<MapPositions> savedToMapPositions(List<BusinessSavedPosition> list){
        ArrayList<MapPositions> result = new ArrayList<>();

        for (int i = list.size() -1; i > -1; i--){
            result.add(toMapPosition(list.get(i)));
        }

        return result;
    }

    private MapPositions toMapPosition(BusinessSavedPosition businessSavedPosition){
        return new MapPositions(
                businessSavedPosition.getDate(),
                businessSavedPosition.getLatitude(),
                businessSavedPosition.getLongitude()
        );
    }
}
