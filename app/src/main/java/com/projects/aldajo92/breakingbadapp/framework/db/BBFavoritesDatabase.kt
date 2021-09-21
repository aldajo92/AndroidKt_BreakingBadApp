package com.projects.aldajo92.breakingbadapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.projects.aldajo92.breakingbadapp.framework.db.entities.FavoriteCharactersEntity

@Database(entities = [FavoriteCharactersEntity::class], version = 3)
@TypeConverters(RoomConverters::class)
abstract class BBFavoritesDatabase : RoomDatabase() {
    abstract fun getFavoriteCharactersDao(): FavoriteCharactersDao
}
