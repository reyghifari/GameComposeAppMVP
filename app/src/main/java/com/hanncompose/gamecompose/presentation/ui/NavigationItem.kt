package com.hanncompose.gamecompose.presentation.ui

import androidx.compose.ui.graphics.vector.ImageVector
import com.hanncompose.gamecompose.presentation.Screen

data class NavigationItem(
    val title : String,
    val icon : ImageVector,
    val screen : Screen
)