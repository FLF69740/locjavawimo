package com.flf69740.testwimova.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.flf69740.testwimova.R;
import com.flf69740.testwimova.modele.MapPositions;
import com.flf69740.testwimova.rx.Response;
import com.flf69740.testwimova.viewmodel.MainViewModel;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {}

    private MainViewModel mainViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.response().observe(getViewLifecycleOwner(), this::processResponse);

        Button myBtn = view.findViewById(R.id.button_temp);
        myBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mainViewModel.runMapPositions(getContext());
    }


    private void processResponse(Response response) {
        switch (response.status) {
            case LOADING:
                renderLoadingState();
                break;

            case SUCCESS:
                renderDataState(response.data);
                break;

            case ERROR:
                renderErrorState(response.error);
                break;
        }
    }

    private void renderLoadingState() {
        Toast.makeText(getContext(), "LOADING", Toast.LENGTH_SHORT).show();
    }

    private void renderDataState(@Nullable MapPositions response){
        if (response != null) {
            Toast.makeText(getContext(), response.getLatitude() + " - " + response.getLongitude(), Toast.LENGTH_SHORT).show();
        }
    }

    private void renderErrorState(Throwable throwable){
        Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
    }
}