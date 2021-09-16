package com.projects.aldajo92.breakingbadapp.domain

import java.io.Serializable

class BBCharacter(
    val id : String = "",
    val name: String = "",
    val isFavorite: Boolean = false,
    val imageUrl: String = "",
    val description: String = ""
) : Serializable {
    companion object {
        val EMPTY = BBCharacter("0", "",false)
    }
}