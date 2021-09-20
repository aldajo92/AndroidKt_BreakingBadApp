package com.projects.aldajo92.breakingbadapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.db.BBFavoritesDatabase
import com.projects.aldajo92.breakingbadapp.framework.db.dao.FavoriteCharactersDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Instrumented test to  test database operations.
 * TODO: ADD Robolectric
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var favoriteCharactersDao: FavoriteCharactersDao

    private lateinit var db: BBFavoritesDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, BBFavoritesDatabase::class.java).build()
        favoriteCharactersDao = db.getFavoriteCharactersDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun when_dbSaveFavoriteCharacter_then_itIsLoadedSuccessfully() = runBlocking {
        val favoriteCharacterEntity =
            BBCharacter(
                "2",
                nickName = "ch2",
                name = "character2",
                isFavorite = true
            ).toEntityModel("")

        favoriteCharactersDao.addFavoriteCharacter(favoriteCharacterEntity)

        val characterLoaded = favoriteCharactersDao.getFavoriteProduct("2")
        assertTrue(characterLoaded == favoriteCharacterEntity)
    }

    @Test
    @Throws(Exception::class)
    fun when_dbRemoveFavoriteCharacter_then_itIsNotReturned() = runBlocking {
        favoriteCharactersDao.deleteById("2")

        val characterCount = favoriteCharactersDao.getFavoriteProduct("2")
        assertNull(characterCount)
    }

}
