package com.projects.aldajo92.breakingbadapp.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bb_favorites")
data class FavoriteCharactersEntity(
    @PrimaryKey val characterID: String,
    val name: String,
    val nickName: String,
    val occupation: String,
    val portrayed: String,
    val bornDate: String,
    val imgPath: String = "",
    val imgUrl: String = ""
)
