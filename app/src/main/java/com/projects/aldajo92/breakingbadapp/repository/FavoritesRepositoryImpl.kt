package com.projects.aldajo92.breakingbadapp.repository

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.repository.FavoritesRepository

class FavoritesRepositoryImpl : FavoritesRepository<BBCharacter> {

    override fun setFavoriteItem(item: BBCharacter) {

    }

    override fun getFavoriteItems(): List<BBCharacter>? {
        return emptyList()
    }

}