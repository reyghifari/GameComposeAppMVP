package com.hanncompose.gamecompose.data.remote

import com.hann.gamecomposeapp.data.remote.dto.GameDetailDto
import com.hanncompose.gamecompose.data.remote.dto.ListGameResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GameaApi {

    @GET("/api/games?key=b73be3ee0ac445ec85a03fd34fd523c1")
    suspend fun getGames(): ListGameResponse

    @GET("/api/games/{gameId}?key=b73be3ee0ac445ec85a03fd34fd523c1")
    suspend fun getGameById(
        @Path("gameId") gameId :String
    ) : GameDetailDto

}