package com.flf69740.core.usecases;

import android.content.Context;

import com.flf69740.core.Modele.BusinessMapPosition;

import io.reactivex.Single;

public interface GetMapPositionsUseCase {
    Single<BusinessMapPosition> execute(Context context, String date);
}
