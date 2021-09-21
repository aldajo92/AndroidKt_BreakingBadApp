package com.projects.aldajo92.breakingbadapp.repository

import com.projects.aldajo92.breakingbadapp.PAGINATION_AMOUNT
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.db.FavoriteCharactersDao
import com.projects.aldajo92.breakingbadapp.framework.network.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.framework.network.models.BBCharactersResponse
import com.projects.aldajo92.breakingbadapp.toEntityModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterRepositoryImplTest {

    @Mock
    lateinit var breakingBadApi: BreakingBadApi

    @Mock
    lateinit var favoriteCharacterDao: FavoriteCharactersDao

    lateinit var characterRepositoryImpl: CharacterRepositoryImpl

    @Before
    fun setup() {
        characterRepositoryImpl = CharacterRepositoryImpl(breakingBadApi, favoriteCharacterDao)
    }

    @Test
    fun when_getFirstSearch_then_retrievesFavoritesAndResult() = runBlocking {

        val favoritesItems = listOf(
            BBCharacter("1", "name1", isFavorite = true),
            BBCharacter("4", "name2", isFavorite = true)
        ).map { it.toEntityModel("") }

        val fetchItems = listOf(
            BBCharactersResponse("1", "name1"),
            BBCharactersResponse("2", "name2"),
            BBCharactersResponse("3", "name3"),
            BBCharactersResponse("4", "name4")
        )

        Mockito.`when`(favoriteCharacterDao.getAllCharacters()).thenReturn(favoritesItems)
        Mockito.`when`(breakingBadApi.getCharacterByPagination(PAGINATION_AMOUNT, 0)).thenReturn(fetchItems)

        val result = characterRepositoryImpl.performFirstSearch().map { it.id }

        assertEquals(listOf("4", "1", "2", "3"), result)
    }
}