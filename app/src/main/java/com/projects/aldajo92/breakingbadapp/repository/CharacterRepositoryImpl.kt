package com.projects.aldajo92.breakingbadapp.repository

import android.graphics.Bitmap
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.framework.db.dao.FavoriteCharactersDao
import com.projects.aldajo92.breakingbadapp.toEntityModel
import java.io.FileOutputStream
import java.io.IOException

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

}
