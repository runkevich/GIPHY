package com.gmail.runkevich8.utils;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.runkevich8.domain.entity.Gif;
import com.gmail.runkevich8.searchgif.databinding.ItemGifBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Gif> gifs = new ArrayList<>();

    public void setGifs(List<Gif> gifs) {
        this.gifs.clear();
        this.gifs.addAll(gifs);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGifBinding binding = ItemGifBinding.inflate(inflater, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder holderT = (Holder) holder;

        holderT.itemGifBinding.setGif(gifs.get(position));

    }

    @Override
    public int getItemCount() {
        return gifs.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ItemGifBinding itemGifBinding;

        Holder(View itemView) {
            super(itemView);
            itemGifBinding = DataBindingUtil.bind(itemView);
        }
    }

}