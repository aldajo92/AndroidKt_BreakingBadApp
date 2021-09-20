package com.projects.aldajo92.breakingbadapp

import android.content.Context
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.db.BBFavoritesDatabase
import com.projects.aldajo92.breakingbadapp.framework.db.dao.FavoriteCharactersDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

/**
 * Instrumented test to  test database operations.
 */
@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class DatabaseTest {

    private lateinit var context: Context

    private lateinit var favoriteCharactersDao: FavoriteCharactersDao

    private lateinit var db: BBFavoritesDatabase

    @Before
    fun createDb() {
        context = ApplicationProvider.getApplicationContext()
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
