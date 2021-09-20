package com.projects.aldajo92.breakingbadapp.repository

interface CharactersRepository<T> {

    suspend fun getItems(): List<T>?

    fun setFavoriteItem(item: T)

    fun getFavoriteItems(): List<T>?

}
