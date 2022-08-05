package com.example.mockyfourparameters.network

import com.squareup.moshi.Json

data class Character(
    @Json(name = "titleKA")
    val titleKA: String,
    @Json(name = "cover")
    val cover: String,
    @Json(name = "publish_date")
    val publish_date: String,
    @Json(name = "descriptionKA")
    val descriptionKA : String
)

data class CharacterResponse(
    @Json(name = "result")
    val result : List<Character>
)