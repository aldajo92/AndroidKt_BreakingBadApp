package com.projects.aldajo92.breakingbadapp

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.db.entities.FavoriteCharactersEntity

fun BBCharacter.toEntityModel(imgPath: String): FavoriteCharactersEntity {
    return FavoriteCharactersEntity(id, nickName, name, "", portrayed, "", imgPath, imageUrl)
}