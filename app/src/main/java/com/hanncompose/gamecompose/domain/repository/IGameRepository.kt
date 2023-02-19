package com.hanncompose.gamecompose.domain.repository

import com.hann.gamecomposeapp.data.remote.dto.GameDetailDto
import com.hanncompose.gamecompose.data.remote.dto.ListGameResponse

interface IGameRepository {

    suspend fun getGames() : ListGameResponse

    suspend fun getGameById(gameId : String) : GameDetailDto
}