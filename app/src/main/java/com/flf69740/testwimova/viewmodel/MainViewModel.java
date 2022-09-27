package com.flf69740.testwimova.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.flf69740.core.usecases.GetMapPositionsUseCase;
import com.flf69740.testwimova.mapper.MapPositionsMapper;
import com.flf69740.testwimova.rx.Response;
import com.flf69740.testwimova.rx.SchedulersFacade;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final SchedulersFacade schedulersFacade;
    private final MutableLiveData<Response> response = new MutableLiveData<>();
    private final MutableLiveData<String> counter = new MutableLiveData<>();

    public MutableLiveData<Response> response(){
        return response;
    }
    public MutableLiveData<String> counter() {
        return counter;
    }

    private final GetMapPositionsUseCase getMapPositions;

    private final CompositeDisposable disposables = new CompositeDisposable();

    private Long decimalDecrement = 0L;

    @Inject
    MainViewModel(
        SchedulersFacade schedulersFacade,
        GetMapPositionsUseCase getMapPositions
    ){
        this.schedulersFacade = schedulersFacade;
        this.getMapPositions = getMapPositions;
    }

    // COUNTER

    private Observable<Long> getObservable(){
        return Observable
                .interval(1, TimeUnit.SECONDS)
                .subscribeOn(schedulersFacade.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void runCounter(Context context) {
        getObservable().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposables.add(d);
            }

            @Override
            public void onNext(Long aLong) {
                if (aLong % 10 == 0) {
                    decimalDecrement += 10;
                    runMapPositions(context);
                }
                counter.postValue(String.valueOf(Math.abs(aLong - decimalDecrement)));
            }

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onComplete() {}
        });
    }

    public void stopCounter(){
        disposables.clear();
    }

    // MAP POSITION

    private void runMapPositions(Context context){
        executeMapPositions(getMapPositions, context);
    }

    private void executeMapPositions(GetMapPositionsUseCase mapPositionUseCase, Context context) {
        Disposable disposable = mapPositionUseCase.execute(context)
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        mapPosition -> response.postValue(Response.success(
                                new MapPositionsMapper()
                                        .toMapPositions(mapPosition))
                        ),
                        throwable -> response.postValue(Response.error(throwable))
                );

        disposables.add(disposable);
    }


}
