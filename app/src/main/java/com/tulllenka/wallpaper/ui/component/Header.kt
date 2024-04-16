package com.tulllenka.wallpaper.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tulllenka.wallpaper.R
import com.tulllenka.wallpaper.ui.theme.Colors
import com.tulllenka.wallpaper.ui.theme.Icons
import com.tulllenka.wallpaper.ui.theme.Typography
import com.tulllenka.wallpaper.utils.str
import com.tulllenka.wallpaper.utils.svg

@Composable
fun Header(
    onClickMenu: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(50.dp)
    ) {
        IconButton(onClick = onClickMenu) {
            Icon(
                painter = Icons.menu.svg(),
                contentDescription = "menu",
                tint = Colors.white
            )
        }
        Text(
            text = R.string.app_name.str(),
            fontFamily = Typography.UbuntuMono,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = Colors.white
        )
        IconButton(onClick = onClickMenu) {
            Icon(
                painter = Icons.github.svg(),
                contentDescription = "github",
                tint = Colors.white
            )
        }
    }
}