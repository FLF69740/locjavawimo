package com.flf69740.testwimova.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.flf69740.testwimova.R;
import com.flf69740.testwimova.viewmodel.MainViewModel;
import com.flf69740.testwimova.modele.MapPositions;
import com.flf69740.testwimova.rx.Response;
import javax.annotation.Nullable;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.response().observe(this, this::processResponse);

        Button myBtn = findViewById(R.id.button_temp);

        myBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mainViewModel.runMapPositions();
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
        Toast.makeText(this, "LOADING", Toast.LENGTH_SHORT).show();
    }

    private void renderDataState(@Nullable MapPositions response){
        if (response != null) {
            Toast.makeText(this, response.getPosX(), Toast.LENGTH_SHORT).show();
        }
    }

    private void renderErrorState(Throwable throwable){
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }
}