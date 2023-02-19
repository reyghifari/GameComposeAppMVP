package com.hann.gamecomposeapp.presentation.home

import com.hanncompose.gamecompose.domain.model.Game

data class GameListState(
    val isLoading : Boolean = false,
    val games: List<Game> = emptyList(),
    val error: String = ""
)