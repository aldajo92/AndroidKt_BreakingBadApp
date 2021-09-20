package com.projects.aldajo92.breakingbadapp.repository

interface CharactersRepository<T> {

    suspend fun getItems(): List<T>?

    suspend fun saveFavoriteItem(item: T)

    suspend fun removeFavoriteItem(key: String?)

    suspend fun getFavoriteItems(): List<T>?

}
