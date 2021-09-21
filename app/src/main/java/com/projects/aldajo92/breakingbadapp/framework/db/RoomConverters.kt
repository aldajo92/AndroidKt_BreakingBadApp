package com.projects.aldajo92.breakingbadapp.framework.db

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class RoomConverters {

    private val moshi = Moshi.Builder().build()
    private val type = Types.newParameterizedType(List::class.java, String::class.java)
    private val adapter = moshi.adapter<List<String>>(type)

    @TypeConverter
    fun fromString(value: String?): List<String>? = value?.let {
        adapter.fromJson(value)
    }

    @TypeConverter
    fun toString(value: List<String>?): String? = value?.let {
        adapter.toJson(value)
    }

}