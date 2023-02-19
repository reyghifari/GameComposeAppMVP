package com.hann.gamecomposeapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanncompose.gamecompose.common.Resource
import com.hanncompose.gamecompose.domain.usecase.get_coins.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : ViewModel(){

    private val _state = mutableStateOf<GameListState>(GameListState())
    val state : State<GameListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getGamesUseCase().onEach {
                result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = GameListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = GameListState(error = result.message ?: "An unexpected Error occured")
                }
                is Resource.Success -> {
                    _state.value = GameListState(games = result.data ?: emptyList())
                }

            }
        }.launchIn(viewModelScope)
    }
}