package com.justin.valley.utils

import android.graphics.drawable.ColorDrawable
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.justin.valley.R


@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder( ColorDrawable(ContextCompat.getColor(view.context, R.color.grey_c1)))
        Glide.with(view.context).load(url).apply(options).into(view)
    }
}

@BindingAdapter("roundImageUrl")
fun loadRoundImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        val options: RequestOptions = RequestOptions()
            .placeholder(ContextCompat.getDrawable(view.context,R.drawable.bg_rectangle_round))
            .error(ContextCompat.getDrawable(view.context,R.drawable.bg_rectangle_round))
            .circleCrop()
        Glide.with(view.context)
            .load(url)
            .apply(options).into(view)
    }
}

@BindingAdapter("loadImage")
fun loadLargeImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        val options: RequestOptions = RequestOptions()
            .placeholder( ColorDrawable(ContextCompat.getColor(view.context, R.color.grey_c1)))
        Glide.with(view.context).load(url).apply(options).into(view)
    }
}