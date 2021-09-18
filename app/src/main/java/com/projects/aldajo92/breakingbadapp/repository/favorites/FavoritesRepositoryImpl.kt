package com.projects.aldajo92.breakingbadapp.repository.favorites

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter

class FavoritesRepositoryImpl : FavoritesRepository<BBCharacter>  {

    override fun setFavoriteItem(item: BBCharacter) {

    }

    override fun getFavoriteItems(): List<BBCharacter>? {
        return emptyList()
    }

}