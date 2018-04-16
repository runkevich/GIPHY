package com.gmail.runkevich8.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;

import com.gmail.runkevich8.domain.entity.Gif;

import java.util.List;


public class SetEntriesRVAdapter {

    @BindingAdapter("android:entries")
    public static void setAdaptRW(RecyclerView recyclerView, ObservableField<List<Gif>> gifs) {
        AdapterRV adapterRV = (AdapterRV) recyclerView.getAdapter();
        if (gifs.get() != null)
            adapterRV.setGifs(gifs.get());
    }
}
