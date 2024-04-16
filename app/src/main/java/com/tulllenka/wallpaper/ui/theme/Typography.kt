package com.tulllenka.wallpaper.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.tulllenka.wallpaper.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

object Typography {
    val Ubuntu = FontFamily(
        Font(R.font.ubuntu_bold, FontWeight.Bold),
        Font(R.font.ubuntu_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.ubuntu_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.ubuntu_light, FontWeight.Light),
        Font(R.font.ubuntu_lightitalic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.ubuntu_medium, FontWeight.Medium),
        Font(R.font.ubuntu_mediumitalic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.ubuntu_regular, FontWeight.Normal),
    )

    val UbuntuMono = FontFamily(
        Font(R.font.ubuntumono_bold, FontWeight.Bold),
        Font(R.font.ubuntumono_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.ubuntumono_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.ubuntumono_regular, FontWeight.Normal),
    )

//    val type = Typography(
//        bodyLarge = TextStyle(
//            fontFamily = FontFamily.Default,
//            fontWeight = FontWeight.Normal,
//            fontSize = 16.sp,
//            lineHeight = 24.sp,
//            letterSpacing = 0.5.sp
//        )
//    )
}