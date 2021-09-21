package com.projects.aldajo92.breakingbadapp.repository

interface CharactersRepository<T> {

    suspend fun performFirstSearch(): List<T>?

    suspend fun fetchItemsPagination(limit: Int, offset: Int): List<T>?

    suspend fun saveFavoriteItem(item: T)

    suspend fun removeFavoriteItem(key: String?)

    suspend fun getFavoriteItems(): List<T>?

    suspend fun toggleFavoriteCharacterState(item: T, state: Boolean)

}
