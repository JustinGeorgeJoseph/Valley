package com.justin.valley.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
        Glide.with(view.context).load(url).apply(options).into(view)
    }
}

@BindingAdapter("roundImageUrl")
fun loadRoundImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
        Glide.with(view.context).load(url).apply(options).into(view)
    }
}

@BindingAdapter("loadImage")
fun loadLargeImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {

        Glide.with(view.context).load(url).into(view)
    }
}