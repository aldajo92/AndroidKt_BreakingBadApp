package com.projects.aldajo92.breakingbadapp.presentation.adapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class GenericItem<T>(
    val data: T,
    @LayoutRes val layoutId: Int
) {
    abstract fun bind(binding: ViewDataBinding, listener: ItemListener<T>)
}
