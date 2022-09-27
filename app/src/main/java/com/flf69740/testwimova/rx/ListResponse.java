package com.flf69740.testwimova.rx;

import static com.flf69740.testwimova.rx.Status.ERROR;
import static com.flf69740.testwimova.rx.Status.LOADING;
import static com.flf69740.testwimova.rx.Status.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.flf69740.testwimova.modele.MapPositions;

import java.util.List;

public class ListResponse {
    public final Status status;

    @Nullable
    public final List<MapPositions> data;

    @Nullable
    public final Throwable error;

    private ListResponse(Status status, @Nullable List<MapPositions> data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ListResponse loading() {
        return new ListResponse(LOADING, null, null);
    }

    public static ListResponse success(@NonNull List<MapPositions> data) {
        return new ListResponse(SUCCESS, data, null);
    }

    public static ListResponse error(@NonNull Throwable error) {
        return new ListResponse(ERROR, null, error);
    }
}
