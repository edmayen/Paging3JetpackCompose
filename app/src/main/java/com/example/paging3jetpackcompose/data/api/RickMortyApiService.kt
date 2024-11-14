package com.example.paging3jetpackcompose.data.api

import com.example.paging3jetpackcompose.data.api.response.GetCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {

    @GET("/api/character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): GetCharactersResponse

}