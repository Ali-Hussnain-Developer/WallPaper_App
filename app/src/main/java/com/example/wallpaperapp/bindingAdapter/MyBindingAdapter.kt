package com.example.wallpaperapp.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object MyBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, url: Int) {
        Glide.with(view).load(url).fitCenter().into(view)
    }

}

