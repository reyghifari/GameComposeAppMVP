package com.hanncompose.gamecompose.domain.usecase.get_coin

import com.hann.gamecomposeapp.data.remote.dto.toGameDetail
import com.hanncompose.gamecompose.common.Resource
import com.hanncompose.gamecompose.domain.model.GameDetail
import com.hanncompose.gamecompose.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGameUseCase @Inject constructor(
    private val repository: IGameRepository
) {
    operator fun invoke(gameId: String):Flow<Resource<GameDetail>> = flow {
        try {
            emit(Resource.Loading<GameDetail>())
            val game = repository.getGameById(gameId).toGameDetail()
            emit(Resource.Success<GameDetail>(game))
        }catch (e:HttpException){
            emit(Resource.Error<GameDetail>(e.localizedMessage ?: "An unexpected Error Occured"))
        }catch (e: IOException){
            emit(Resource.Error<GameDetail>("Couldnt't reach server. Check your internet server"))
        }
    }
}