package com.projects.aldajo92.breakingbadapp.framework.network.search

import com.squareup.moshi.Json

data class CharactersResponse(
    @Json(name = "char_id") val charId: String = "",
    val birthday: String = "",
    val occupation: List<String>? = emptyList(),
    @Json(name = "img") val imageUrl: String = "",
    val status: String = "",
    val appearance: List<Int> = emptyList(),
    @Json(name = "nickname") val nickName: String = "",
    val portrayed: String = ""
)
