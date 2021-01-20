package com.example.movie.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R

fun ImageView.loadImage(path: String) {

    Glide.with(this).clear(this)
    Glide.with(this)
        .setDefaultRequestOptions(
            RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_image_search)
                .error(R.drawable.ic_broken_image_gray)
        )
        .load(path).into(this)
}

