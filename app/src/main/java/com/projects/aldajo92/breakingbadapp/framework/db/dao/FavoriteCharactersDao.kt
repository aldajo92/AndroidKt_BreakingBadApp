package com.projects.aldajo92.breakingbadapp.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.projects.aldajo92.breakingbadapp.framework.db.entities.FavoriteCharactersEntity

@Dao
interface FavoriteCharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteProduct(product: FavoriteCharactersEntity)

    @Query("DELETE FROM bb_favorites WHERE characterID = :key")
    suspend fun deleteById(key: String)

    @Query("DELETE FROM bb_favorites")
    suspend fun deleteAll()

    @Query("SELECT * FROM bb_favorites")
    suspend fun getAllProducts(): List<FavoriteCharactersEntity>

    @Query("SELECT * FROM bb_favorites WHERE characterID = :key")
    suspend fun getFavoriteProduct(key: String): FavoriteCharactersEntity

}
