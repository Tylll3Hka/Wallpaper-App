package com.tulllenka.wallpaper.utils

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@SuppressLint("SupportAnnotationUsage")
@DrawableRes
@Composable
fun Int.svg() = painterResource(id = this)

@SuppressLint("SupportAnnotationUsage")
@Composable
@StringRes
fun Int.str() = stringResource(id = this)