package com.projects.aldajo92.breakingbadapp.presentation.ui.utils

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.projects.aldajo92.breakingbadapp.R

@BindingAdapter("favoriteMarkState")
fun favoriteMarkState(imageView: ImageView, marked: Boolean) {
    imageView.setImageDrawable(
        ContextCompat.getDrawable(
            imageView.context, if (marked) R.drawable.ic_star_marked else R.drawable.ic_star
        )
    )
}

@BindingAdapter("imageFromUrl")
fun imageFromUrl(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView)
        .load(imageUrl)
        .into(imageView)
}
