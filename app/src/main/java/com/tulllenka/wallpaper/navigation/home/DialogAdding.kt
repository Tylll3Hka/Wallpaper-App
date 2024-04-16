package com.tulllenka.wallpaper.navigation.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tulllenka.wallpaper.R
import com.tulllenka.wallpaper.ui.component.CustomDialog
import com.tulllenka.wallpaper.ui.component.DialogButton
import com.tulllenka.wallpaper.ui.theme.Colors
import com.tulllenka.wallpaper.ui.theme.Shapes
import com.tulllenka.wallpaper.ui.theme.Typography
import com.tulllenka.wallpaper.utils.str

@Composable
fun DialogAdding(
    openDialog: MutableState<Boolean>,
    context: Context,
    onClickSave: () -> Unit,
    onClickCancel: () -> Unit,
    content: @Composable () -> Unit
) {
    CustomDialog(openDialog, onClickCancel) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Colors.backgroundModal, Shapes.medium)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = R.string.adding.str(),
                fontFamily = Typography.UbuntuMono,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Colors.white
            )
            Spacer(modifier = Modifier.height(15.dp))
            content()
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                DialogButton(
                    title = R.string.cancel.str(),
                    modifier = Modifier.weight(1f),
                    onClickCancel
                )
                Spacer(modifier = Modifier.width(10.dp))
                DialogButton(
                    title = R.string.save.str(),
                    modifier = Modifier.weight(1f),
                    onClickSave
                )
            }

        }
    }
}