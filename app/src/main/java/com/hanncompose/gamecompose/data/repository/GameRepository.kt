package com.hanncompose.gamecompose.data.repository

import com.hann.gamecomposeapp.data.remote.dto.GameDetailDto
import com.hanncompose.gamecompose.data.remote.GameaApi
import com.hanncompose.gamecompose.data.remote.dto.ListGameResponse
import com.hanncompose.gamecompose.domain.repository.IGameRepository
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val api: GameaApi
) : IGameRepository {

    override suspend fun getGames(): ListGameResponse {
        return api.getGames()
    }

    override suspend fun getGameById(gameId: String): GameDetailDto {
        return api.getGameById(gameId)
    }


}