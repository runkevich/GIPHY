package com.gmail.runkevich8.utils;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AdapterGifDataBinding {

    @BindingAdapter("android:src")
    public static void setImageUrl(@NonNull ImageView imageView, @NonNull String url) {
        Context context = imageView.getContext();

        Glide.with(context)
                .asGif()
                .load(url)
                .into(imageView);
    }
}
