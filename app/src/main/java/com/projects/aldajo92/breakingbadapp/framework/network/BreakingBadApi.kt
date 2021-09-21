package com.projects.aldajo92.breakingbadapp.framework.network

import com.projects.aldajo92.breakingbadapp.framework.network.models.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface BreakingBadApi {

    @GET("characters")
    suspend fun getCharacterByPagination(
        @Query("limit") limit: Int = 0,
        @Query("offset") offset: Int = 0
    ): List<CharactersResponse>?

}
