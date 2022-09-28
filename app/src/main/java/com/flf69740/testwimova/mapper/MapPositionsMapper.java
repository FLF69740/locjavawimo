package com.flf69740.testwimova.mapper;

import com.flf69740.core.Modele.BusinessMapPosition;
import com.flf69740.core.Modele.BusinessSavedPosition;
import com.flf69740.testwimova.modele.MapPositions;

import java.util.ArrayList;
import java.util.List;

public class MapPositionsMapper {
    public MapPositions toMapPositions(BusinessMapPosition businessMapPosition, String date){
        return new  MapPositions(
                date,
                businessMapPosition.getLatitude(),
                businessMapPosition.getLongitude()
        );
    }

    public List<MapPositions> savedToMapPositions(List<BusinessSavedPosition> list){
        ArrayList<MapPositions> result = new ArrayList<>();

        for (BusinessSavedPosition position : list){
            result.add(toMapPosition(position));
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
