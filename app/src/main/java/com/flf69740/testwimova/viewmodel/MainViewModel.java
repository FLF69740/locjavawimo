package com.flf69740.testwimova.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.flf69740.core.usecases.GetMapPositionsUseCase;
import com.flf69740.testwimova.mapper.MapPositionsMapper;
import com.flf69740.testwimova.rx.Response;
import com.flf69740.testwimova.rx.SchedulersFacade;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final SchedulersFacade schedulersFacade;
    private final MutableLiveData<Response> response = new MutableLiveData<>();

    private final GetMapPositionsUseCase getMapPositions;

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    MainViewModel(
        SchedulersFacade schedulersFacade,
        GetMapPositionsUseCase getMapPositions
    ){
        this.schedulersFacade = schedulersFacade;
        this.getMapPositions = getMapPositions;
    }

    public void runMapPositions(Context context){
        runMapPositions(getMapPositions, context);
    }

    public MutableLiveData<Response> response(){
        return response;
    }

    private void runMapPositions(GetMapPositionsUseCase greetingUseCase, Context context) {
        disposables.add(greetingUseCase.execute(context)
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        greeting -> response.setValue(Response.success(
                                new MapPositionsMapper()
                                        .toMapPositions(greeting))
                        ),
                        throwable -> response.setValue(Response.error(throwable))
                )
        );
    }


}
