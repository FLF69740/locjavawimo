package com.flf69740.testwimova.ui;

import androidx.fragment.app.Fragment;
import com.flf69740.testwimova.R;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {

    @Override
    protected Fragment getFirstFragment() {
        return MainFragment.newInstance();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentLayout() {
        return R.id.frame_layout_main;
    }
}