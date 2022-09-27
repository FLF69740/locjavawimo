package com.flf69740.datas.mapper;

import com.flf69740.core.Modele.BusinessSavedPosition;
import com.flf69740.datas.modele.SavedPosition;
import java.util.ArrayList;
import java.util.List;

public class BusinessSavedPositionsMapper {

    public SavedPosition toDataSavedPosition(BusinessSavedPosition position){
        return new SavedPosition(
            position.getLatitude(), position.getLongitude(), position.getDate()
        );
    }

    public List<BusinessSavedPosition> toBusinessSavedPositions(List<SavedPosition> list){
        ArrayList<BusinessSavedPosition> result = new ArrayList<>();

        for (int i = list.size() -1; i > -1; i--){
            result.add(toBusinessSavedPosition(list.get(i)));
        }

        return result;
    }

    private BusinessSavedPosition toBusinessSavedPosition(SavedPosition savedPosition){
        return new BusinessSavedPosition(
                savedPosition.getDate(),
                savedPosition.getLatitude(),
                savedPosition.getLongitude()
        );
    }
}
