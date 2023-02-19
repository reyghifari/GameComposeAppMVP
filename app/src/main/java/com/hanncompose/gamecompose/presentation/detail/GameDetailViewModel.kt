package com.hann.gamecomposeapp.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanncompose.gamecompose.common.Constants
import com.hanncompose.gamecompose.common.Resource
import com.hanncompose.gamecompose.domain.usecase.get_coin.GetGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val getGameUseCase: GetGameUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf<GameDetailState>(GameDetailState())
    val state : State<GameDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_GAME_ID)?.let {
                coinId ->
            getGame(coinId)
        }

    }


    private fun getGame(gameId : String){
        getGameUseCase(gameId).onEach {
                result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = GameDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = GameDetailState(error = result.message ?: "An unexpected Error occured")
                }
                is Resource.Success -> {
                    _state.value = GameDetailState(game = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}