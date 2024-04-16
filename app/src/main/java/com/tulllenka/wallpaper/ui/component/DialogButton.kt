package com.tulllenka.wallpaper.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tulllenka.wallpaper.ui.theme.Colors
import com.tulllenka.wallpaper.ui.theme.Shapes
import com.tulllenka.wallpaper.ui.theme.Typography

@Composable
fun DialogButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.primary
        ),
        shape = Shapes.medium,
        modifier = modifier.height(50.dp)
    ) {
        Text(
            text = title,
            fontFamily = Typography.UbuntuMono,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Colors.white
        )
    }
}