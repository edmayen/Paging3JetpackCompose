package com.example.paging3jetpackcompose.di

import com.example.paging3jetpackcompose.data.api.RickMortyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val  BASE_URL = "https://rickandmortyapi.com"

    @Provides
    fun providesApiService(retrofit: Retrofit): RickMortyApiService =
        retrofit.create(RickMortyApiService::class.java)

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

}