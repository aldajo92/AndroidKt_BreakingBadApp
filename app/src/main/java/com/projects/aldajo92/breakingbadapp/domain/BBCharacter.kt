package com.projects.aldajo92.breakingbadapp.domain

import java.io.Serializable

class BBCharacter(
    val id : String = "",
    val name: String = "", //TODO: Rename to nickName Name
    val isFavorite: Boolean = false,
    val imageUrl: String = "",
    val status: String = "",
    val description: String = "", //TODO: Rename to original Name
    val occupation: List<String>? = emptyList(),
    val portrayed: String = ""
) : Serializable {
    companion object {
        val EMPTY = BBCharacter("0", "",false)
    }
}