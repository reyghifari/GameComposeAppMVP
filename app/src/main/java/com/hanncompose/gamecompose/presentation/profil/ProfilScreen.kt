package com.hann.gamecomposeapp.presentation.profil

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = "https://media.licdn.com/dms/image/D5603AQGbhtRSx01vXA/profile-displayphoto-shrink_200_200/0/1669276778962?e=1682553600&v=beta&t=5koK5CruOfsFdlYpdCKhaw33Zu7tMJ6gjaXs5LTGv3Y",
                contentDescription = "about_page",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Kgs Muhammad Raihan Ghifari",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "raihan.ghifari1603@gmail.com",
                style = MaterialTheme.typography.body2
            )
        }
    }
}