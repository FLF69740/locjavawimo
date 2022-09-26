package com.flf69740.testwimova.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import javax.annotation.Nullable;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract Fragment getFirstFragment();
    protected abstract int getContentView();
    protected abstract int getFragmentLayout();
    protected abstract void getBody();

    @Nullable Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        bundle = savedInstanceState;
        this.getBody();
    }

    protected void configureFragment(){
        if (bundle == null){
            getSupportFragmentManager().beginTransaction()
                    .add(getFragmentLayout(), getFirstFragment())
                    .commit();
        }
    }
}
