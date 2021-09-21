package com.projects.aldajo92.breakingbadapp.repository

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.network.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.framework.db.FavoriteCharactersDao
import com.projects.aldajo92.breakingbadapp.toBBCharacter
import com.projects.aldajo92.breakingbadapp.toEntityModel

class CharacterRepositoryImpl constructor(
    private val breakingBadApi: BreakingBadApi,
    private val favoritesDao: FavoriteCharactersDao
) : CharactersRepository<BBCharacter> {

    private var characters: List<BBCharacter>? = null

    override suspend fun getItems(): List<BBCharacter> {
        val responseList = breakingBadApi.getCharacterByPagination(100, 0) ?: emptyList()
        return responseList.map {
            it.toBBCharacter()
        }
    }

    override suspend fun saveFavoriteItem(item: BBCharacter) {
        val imgPath = saveImageFromUrl()
        favoritesDao.addFavoriteCharacter(item.toEntityModel(imgPath))
    }

    override suspend fun getFavoriteItems(): List<BBCharacter> {
        return emptyList()
    }

    private fun saveImageFromUrl(): String {
        // TODO: Save image to path
        return ""
    }

    override suspend fun removeFavoriteItem(key: String?) {
        key?.let { favoritesDao.deleteById(it) }
    }

}
