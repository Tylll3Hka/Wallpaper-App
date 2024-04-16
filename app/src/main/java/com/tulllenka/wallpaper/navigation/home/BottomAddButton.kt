package com.tulllenka.wallpaper.navigation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tulllenka.wallpaper.R
import com.tulllenka.wallpaper.ui.theme.Colors
import com.tulllenka.wallpaper.ui.theme.Shapes
import com.tulllenka.wallpaper.ui.theme.Typography
import com.tulllenka.wallpaper.utils.str

@Composable
fun BottomAddButton(
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .padding(horizontal = 20.dp)
            .background(Color.Transparent)
    ) {
        Button(
            enabled = enabled,
            onClick = onClick,
            modifier = Modifier.fillMaxSize(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Colors.primary
            ),
            shape = Shapes.medium
        ) {
            Text(
                text = R.string.add_wallpaper_btn.str(),
                fontFamily = Typography.UbuntuMono,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Colors.white
            )
        }
    }
}