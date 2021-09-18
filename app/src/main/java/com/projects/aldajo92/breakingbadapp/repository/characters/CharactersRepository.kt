package com.projects.aldajo92.breakingbadapp.repository.characters

interface CharactersRepository<T> {

    suspend fun getItems(): List<T>?

}
