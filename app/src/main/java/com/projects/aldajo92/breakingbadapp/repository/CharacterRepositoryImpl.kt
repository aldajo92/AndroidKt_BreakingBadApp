package com.projects.aldajo92.breakingbadapp.repository

import com.projects.aldajo92.breakingbadapp.PAGINATION_AMOUNT
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.network.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.framework.db.FavoriteCharactersDao
import com.projects.aldajo92.breakingbadapp.toBBCharacter
import com.projects.aldajo92.breakingbadapp.toEntityModel

class CharacterRepositoryImpl constructor(
    private val breakingBadApi: BreakingBadApi,
    private val favoritesDao: FavoriteCharactersDao
) : CharactersRepository<BBCharacter> {

    private var favoritesCharactersMap: MutableMap<String, BBCharacter> = mutableMapOf()

    override suspend fun performFirstSearch(): List<BBCharacter> {
        val resultCharactersList: MutableList<BBCharacter> = mutableListOf()

        val favoritesCharactersItems = getFavoriteItems()
        favoritesCharactersMap = favoritesCharactersItems.associateBy { it.id }.toMutableMap()

        resultCharactersList.addAll(favoritesCharactersItems)
        val charactersItems = fetchItemsPagination(PAGINATION_AMOUNT, 0).filter { !favoritesCharactersMap.containsKey(it.id) }
        resultCharactersList.addAll(charactersItems)

        return resultCharactersList
    }

    override suspend fun fetchItemsPagination(limit: Int, offset: Int): List<BBCharacter> {
        val responseList = breakingBadApi.getCharacterByPagination(limit, offset) ?: emptyList()
        return responseList.map {
            it.toBBCharacter()
        }
    }

    override suspend fun saveFavoriteItem(item: BBCharacter) {
        val imgPath = saveImageFromUrl()
        favoritesDao.addFavoriteCharacter(item.toEntityModel(imgPath))
    }

    override suspend fun getFavoriteItems(): List<BBCharacter> {
        return favoritesDao.getAllCharacters().map {
            it.toBBCharacter()
        }.reversed()
    }

    private fun saveImageFromUrl(): String {
        // TODO: Save image to path
        return ""
    }

    override suspend fun removeFavoriteItem(key: String?) {
        key?.let { favoritesDao.deleteById(it) }
    }

    override suspend fun toggleFavoriteCharacterState(character: BBCharacter, state: Boolean){
        character.isFavorite = state
        if (state) {
            saveFavoriteItem(character)
        } else {
            removeFavoriteItem(character.id)
        }
    }

}
