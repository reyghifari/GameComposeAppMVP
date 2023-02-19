package com.hanncompose.gamecompose.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hann.gamecomposeapp.presentation.detail.DetailScreen
import com.hann.gamecomposeapp.presentation.home.HomeScreen
import com.hann.gamecomposeapp.presentation.profil.ProfileScreen
import com.hanncompose.gamecompose.presentation.ui.NavigationItem

@Composable
fun GameApp(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.GameDetailScreen.route){
                BottomAppBar(navController)
            }
        },
        modifier = modifier
    ){
        NavHost(
            navController = navController as NavHostController,
            startDestination = Screen.GameListScreen.route,
            modifier = Modifier.padding(it)
        ){
            composable(Screen.GameListScreen.route){
                HomeScreen(navController)
            }
            composable(
                route = Screen.GameDetailScreen.route + "/{gameId}"
            ){
                DetailScreen()
            }
            composable(Screen.GameProfileScreen.route) {
                ProfileScreen()
            }
        }
    }


}

@Composable
fun BottomAppBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItem = listOf(
            NavigationItem(
                title = stringResource(com.hanncompose.gamecompose.R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.GameListScreen
            ),
            NavigationItem(
                title = stringResource(com.hanncompose.gamecompose.R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.GameProfileScreen
            )
        )
        BottomNavigation {
            navigationItem.map {
                    navigationItem ->
                BottomNavigationItem(
                    selected = currentRoute == navigationItem.screen.route,
                    onClick = { navController.navigate(navigationItem.screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    } },
                    label = { Text(text = navigationItem.title)},
                    icon = { Icon(
                        imageVector = navigationItem.icon,
                        contentDescription = navigationItem.title)
                    }
                )
            }
        }
    }

}