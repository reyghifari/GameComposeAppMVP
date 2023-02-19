package com.hanncompose.gamecompose.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.hann.gamecomposeapp.data.remote.dto.Developer

@Composable
fun DeveloperListItem(
    developer: Developer,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = developer.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(
            text = developer.slug,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }

}