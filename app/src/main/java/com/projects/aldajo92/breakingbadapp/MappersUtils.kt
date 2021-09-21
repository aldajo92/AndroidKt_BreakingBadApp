package com.projects.aldajo92.breakingbadapp

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.db.entities.FavoriteCharactersEntity
import com.projects.aldajo92.breakingbadapp.framework.network.models.CharactersResponse

fun BBCharacter.toEntityModel(imgPath: String): FavoriteCharactersEntity =
    FavoriteCharactersEntity(
        id,
        nickName,
        name,
        portrayed,
        bornDate,
        imgPath,
        imageUrl,
        occupation
    )

fun CharactersResponse.toBBCharacter(): BBCharacter = BBCharacter(
    charId,
    nickName,
    false,
    imageUrl,
    status,
    name,
    occupation,
    portrayed,
    birthday
)