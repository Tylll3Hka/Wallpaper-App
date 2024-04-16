package com.tulllenka.wallpaper.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDialog(openDialog: MutableState<Boolean>, onDismissRequest: () -> Unit , content: @Composable () -> Unit) {
    if (openDialog.value) Dialog(onDismissRequest, content = content)
}