package com.projects.aldajo92.breakingbadapp.domain

import java.io.Serializable

data class BBCharacter(
    val id: String = "",
    val nickName: String = "",
    var isFavorite: Boolean = false,
    val imageUrl: String = "",
    val status: String = "",
    val name: String = "",
    val occupation: List<String>? = emptyList(),
    val portrayed: String = "",
    val bornDate: String = ""
) : Serializable {
    companion object {
        val EMPTY = BBCharacter("0", "", false)
    }
}