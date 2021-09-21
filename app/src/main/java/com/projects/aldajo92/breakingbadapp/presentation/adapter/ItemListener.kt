package com.projects.aldajo92.breakingbadapp.presentation.adapter

interface ItemListener<T> {
    fun onClickItem(item: GenericItem<T>)

    fun onFavoriteClicked(item: GenericItem<T>)
}
