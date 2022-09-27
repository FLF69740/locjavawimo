package com.flf69740.testwimova.ui;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.flf69740.testwimova.R;
import com.flf69740.testwimova.modele.MapPositions;
import com.flf69740.testwimova.rx.Response;
import com.flf69740.testwimova.viewmodel.MainViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment implements
        View.OnClickListener,
        OnMapReadyCallback,
        GoogleMap.OnMyLocationClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnMyLocationButtonClickListener
{

    public MainFragment() {}
    private MainViewModel mainViewModel;

    private TextView counterPanel;
    private ProgressBar progressBar;
    private Button start;
    private Button stop;

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
        mainViewModel.counter().observe(getViewLifecycleOwner(), this::showCounter);

        progressBar = view.findViewById(R.id.progress_indicator);

        start = view.findViewById(R.id.button_start);
        start.setOnClickListener(this);

        stop = view.findViewById(R.id.button_stop);
        stop.setOnClickListener(this);

        counterPanel = view.findViewById(R.id.counter_indicator);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null){
            mapFragment.getMapAsync(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_start) {
            mainViewModel.runCounter(getContext());
            changeButtonsState(Pair.create(View.GONE, View.VISIBLE));
        }
        else if (v.getId() == R.id.button_stop) {
            mainViewModel.stopCounter();
            changeButtonsState(Pair.create(View.VISIBLE, View.GONE));
        }
    }

    private void changeButtonsState(Pair<Integer, Integer> stateButton){
        start.setVisibility(stateButton.first);
        progressBar.setVisibility(stateButton.second);
        counterPanel.setVisibility(stateButton.second);
        counterPanel.setText("");
        stop.setVisibility(stateButton.second);
    }

    private void showCounter(String number){
        counterPanel.setText(number);
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
    }

    private void renderDataState(@Nullable MapPositions response){
        if (response != null) {
            Toast.makeText(getContext(), response.getLatitude() + " - " + response.getLongitude(), Toast.LENGTH_SHORT).show();
        }
    }

    private void renderErrorState(Throwable throwable){
        Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
    }

    /*
     * GOOGLE MAP
     */

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setOnMyLocationClickListener(this);
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMyLocationButtonClickListener(this);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(getContext(), "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }
}