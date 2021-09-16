package com.projects.aldajo92.breakingbadapp.repository.characters

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi

class BBCharacterRepositoryImpl constructor(
    private val breakingBadApi: BreakingBadApi
) : CharactersRepository<BBCharacter> {

    private var characters: List<BBCharacter>? = null

    override suspend fun getItems(): List<BBCharacter> {
        val responseList = breakingBadApi.getCharacterByPagination(100, 0) ?: emptyList()
        return responseList.map {
            // TODO: Apply mapper here
            BBCharacter(it.charId, it.nickName, false, it.imageUrl, it.name)
        }
    }

    override fun setFavoriteItem(country: BBCharacter) {

    }

    override fun getFavoriteItems(): List<BBCharacter> {
        return emptyList()
    }

}
