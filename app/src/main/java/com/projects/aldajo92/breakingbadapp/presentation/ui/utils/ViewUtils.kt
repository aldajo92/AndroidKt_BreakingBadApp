package com.projects.aldajo92.breakingbadapp.presentation.ui.utils

import android.widget.ImageView
import android.widget.TextView
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
        .placeholder(R.drawable.ic_default_character)
        .into(imageView)
}

@BindingAdapter("listToText")
fun listToText(textView: TextView, list: List<String>?) {
    list?.let {
        textView.text = list.convertListToSingleString()
    }
}