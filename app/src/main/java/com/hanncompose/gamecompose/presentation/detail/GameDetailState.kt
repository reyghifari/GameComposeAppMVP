package com.hann.gamecomposeapp.presentation.detail

import com.hanncompose.gamecompose.domain.model.GameDetail

data class GameDetailState(
    val isLoading : Boolean = false,
    val game: GameDetail? = null,
    val error: String = ""
)