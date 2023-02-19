package com.hanncompose.gamecompose.domain.usecase.get_coins

import com.hanncompose.gamecompose.common.Resource
import com.hanncompose.gamecompose.data.remote.dto.toGame
import com.hanncompose.gamecompose.domain.model.Game
import com.hanncompose.gamecompose.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: IGameRepository
) {
    operator fun invoke():Flow<Resource<List<Game>>> = flow {
        try {
            emit(Resource.Loading<List<Game>>())
            val games = repository.getGames().results.map { it.toGame() }
            emit(Resource.Success<List<Game>>(games))
        }catch (e:HttpException){
            emit(Resource.Error<List<Game>>(e.localizedMessage ?: "An unexpected Error Occured"))
        }catch (e: IOException){
            emit(Resource.Error<List<Game>>("Couldnt't reach server. Check your internet server"))
        }
    }
}