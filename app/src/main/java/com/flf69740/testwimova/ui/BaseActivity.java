package com.flf69740.testwimova.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract Fragment getFirstFragment();
    protected abstract int getContentView();
    protected abstract int getFragmentLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        this.configureFragment(savedInstanceState);
    }

    protected void configureFragment(Bundle bundle){
        if (bundle == null){
            getSupportFragmentManager().beginTransaction()
                    .add(getFragmentLayout(), getFirstFragment())
                    .commit();
        }
    }
}
