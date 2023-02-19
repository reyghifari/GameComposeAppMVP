package com.hanncompose.gamecompose.presentation

sealed class Screen(val route: String){
    object GameListScreen : Screen("game_list_screen")
    object GameDetailScreen : Screen("game_detail_screen")
    object GameProfileScreen : Screen("game_profile_screen")

}
