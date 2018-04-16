package com.gmail.runkevich8.screen;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crashlytics.android.Crashlytics;
import com.gmail.runkevich8.base.BaseMvvmActivity;
import com.gmail.runkevich8.base.BaseViewModel;
import com.gmail.runkevich8.searchgif.R;
import com.gmail.runkevich8.utils.AdapterRV;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends BaseMvvmActivity{


    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

//    @Override
//    public MainActivityViewModel provideViewModel() {
//        return ViewModelProviders.of(this).get(MainActivityViewModel.class);
//    }
@Override
public BaseViewModel provideViewModel() {
    return ViewModelProviders.of(this).get(MainActivityViewModel.class);
}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recycle);
        recyclerView.setAdapter(new AdapterRV());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
