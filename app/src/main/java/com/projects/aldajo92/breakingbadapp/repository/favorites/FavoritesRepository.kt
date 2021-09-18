package com.projects.aldajo92.breakingbadapp.repository.favorites

interface FavoritesRepository<T>  {
    fun setFavoriteItem(item: T)

    fun getFavoriteItems(): List<T>?
}