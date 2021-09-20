package com.projects.aldajo92.breakingbadapp.repository

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.framework.db.dao.FavoriteCharactersDao

class CharacterRepositoryImpl constructor(
    private val breakingBadApi: BreakingBadApi,
    private val favoritesDao: FavoriteCharactersDao
) : CharactersRepository<BBCharacter> {

    private var characters: List<BBCharacter>? = null

    override suspend fun getItems(): List<BBCharacter> {
        val responseList = breakingBadApi.getCharacterByPagination(100, 0) ?: emptyList()
        return responseList.map {
            // TODO: Apply mapper here
            BBCharacter(
                it.charId,
                it.nickName,
                false,
                it.imageUrl,
                it.status,
                it.name,
                it.occupation,
                it.portrayed
            )
        }
    }

    override fun setFavoriteItem(item: BBCharacter) {

    }

    override fun getFavoriteItems(): List<BBCharacter> {
        return emptyList()
    }

}