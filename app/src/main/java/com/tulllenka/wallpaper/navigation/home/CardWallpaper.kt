package com.tulllenka.wallpaper.navigation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.tulllenka.wallpaper.R
import com.tulllenka.wallpaper.ui.theme.Colors
import com.tulllenka.wallpaper.ui.theme.Shapes
import com.tulllenka.wallpaper.utils.svg

@Composable
fun CardWallpaper() {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                Colors.primary,
                Shapes.medium
            )
            .height(70.dp)
            .fillMaxWidth()
            .clip(Shapes.medium)
    ) {
        Image(painter = R.drawable.image.svg(), contentDescription = null)
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "Evening landscape")
    }
}