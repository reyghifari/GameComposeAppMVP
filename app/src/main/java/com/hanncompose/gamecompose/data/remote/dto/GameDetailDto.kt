package com.hann.gamecomposeapp.data.remote.dto

import com.hanncompose.gamecompose.domain.model.GameDetail

data class GameDetailDto(
    val background_image: String,
    val creators_count: Int,
    val description: String,
    val developers: List<Developer>,
    val id: Int,
    val name: String,
    val playtime: Int,
    val rating: Double,
)

fun GameDetailDto.toGameDetail() : GameDetail {
    return GameDetail(
        background_image = background_image,
        description = description,
        developers = developers,
        id = id,
        name = name,
        playtime = playtime,
        rating = rating
    )
}