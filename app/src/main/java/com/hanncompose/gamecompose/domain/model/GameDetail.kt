package com.hanncompose.gamecompose.domain.model

import com.hann.gamecomposeapp.data.remote.dto.Developer

data class GameDetail(
    val background_image: String,
    val description: String,
    val developers: List<Developer>,
    val id: Int,
    val name: String,
    val playtime: Int,
    val rating: Double,
)
