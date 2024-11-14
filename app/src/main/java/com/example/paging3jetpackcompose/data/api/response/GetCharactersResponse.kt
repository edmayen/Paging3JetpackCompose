package com.example.paging3jetpackcompose.data.api.response

import com.example.paging3jetpackcompose.domain.model.CharacterModel

data class GetCharactersResponse(
    val info: Info,
    val results: List<Result>
)

data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)

fun Result.toDomain(): CharacterModel = CharacterModel(
    id = id,
    name = name,
    isAlive = status == "Alive",
    image = image
)