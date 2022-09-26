package com.flf69740.testwimova.rx;

import static com.flf69740.testwimova.rx.Status.ERROR;
import static com.flf69740.testwimova.rx.Status.LOADING;
import static com.flf69740.testwimova.rx.Status.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.flf69740.testwimova.modele.MapPositions;

public class Response {
    public final Status status;

    @Nullable
    public final MapPositions data;

    @Nullable
    public final Throwable error;

    private Response(Status status, @Nullable MapPositions data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Response loading() {
        return new Response(LOADING, null, null);
    }

    public static Response success(@NonNull MapPositions data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(ERROR, null, error);
    }
}
