package com.projects.aldajo92.breakingbadapp

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.db.entities.FavoriteCharactersEntity
import com.projects.aldajo92.breakingbadapp.framework.network.models.BBCharactersResponse

fun BBCharacter.toEntityModel(imgPath: String) =
    FavoriteCharactersEntity(
        id,
        nickName,
        name,
        portrayed,
        bornDate,
        imgPath,
        imageUrl,
        occupation,
        status
    )

fun BBCharactersResponse.toBBCharacter() =
    BBCharacter(
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

fun FavoriteCharactersEntity.toBBCharacter() =
    BBCharacter(
        characterID,
        nickName,
        true,
        imgUrl,
        status,
        name,
        occupation,
        portrayed,
        bornDate
    )