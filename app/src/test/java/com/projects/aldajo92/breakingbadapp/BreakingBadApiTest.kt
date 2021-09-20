package com.projects.aldajo92.breakingbadapp

import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.framework.network.models.CharactersResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.InputStreamReader

/**
 * Test for BreakingBadApi.
 */
class BreakingBadApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var service: BreakingBadApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(mockWebServer.url("").toString())
            .build()

        service = retrofit.create(BreakingBadApi::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun getAllCharacters() = runBlocking {
        val body = readFile("success_response.json")

        mockWebServer.enqueue(MockResponse().setBody(body))

        val result: List<CharactersResponse> =
            service.getCharacterByPagination(10, 0) ?: emptyList()

        assertEquals(result.count(), 10)
    }

    @Test
    @Throws(IOException::class)
    fun emptyResponse() = runBlocking {
        val body = readFile("empty_response.json")

        mockWebServer.enqueue(MockResponse().setBody(body))

        val result: List<CharactersResponse> =
            service.getCharacterByPagination(10, 0) ?: emptyList()

        assertEquals(result.count(), 0)
    }

    private fun readFile(path: String): String {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        val content = reader.readText()
        reader.close()
        return content
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}