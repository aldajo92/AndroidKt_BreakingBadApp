package com.projects.aldajo92.breakingbadapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.projects.aldajo92.breakingbadapp.framework.db.dao.FavoriteCharactersDao
import com.projects.aldajo92.breakingbadapp.framework.db.entities.FavoriteCharactersEntity

@Database(entities = [FavoriteCharactersEntity::class], version = 2)
abstract class BBFavoritesDatabase : RoomDatabase() {
    abstract fun getFavoriteCharactersDao(): FavoriteCharactersDao
}
