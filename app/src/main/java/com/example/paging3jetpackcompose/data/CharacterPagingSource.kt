package com.example.paging3jetpackcompose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3jetpackcompose.data.api.RickMortyApiService
import com.example.paging3jetpackcompose.data.api.response.toDomain
import com.example.paging3jetpackcompose.domain.model.CharacterModel
import okio.IOException
import javax.inject.Inject

class CharacterPagingSource @Inject constructor( private val apiService: RickMortyApiService): PagingSource<Int, CharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? = state.anchorPosition


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getCharacters(page)
            val characters = response.results

            val prevKey = if (page > 0) page-1 else null
            val nextKey = if (response.info.next != null) page+1 else null

            LoadResult.Page(
                data = characters.map { it.toDomain() },
                prevKey = prevKey,
                nextKey = nextKey
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}