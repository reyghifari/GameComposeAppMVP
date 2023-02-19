package com.hanncompose.gamecompose.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.hanncompose.gamecompose.domain.model.Game

data class GameDto(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("playtime")
    val playtime: String,

    @field:SerializedName("background_image")
    val background_image: String
)

fun GameDto.toGame() : Game {
    return Game(
        background_image = background_image,
        id = id,
        name = name,
        playtime = playtime,
        rating = rating,
        released = released
    )
}

