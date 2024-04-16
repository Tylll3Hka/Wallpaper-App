package com.tulllenka.wallpaper.navigation.home

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tulllenka.wallpaper.R
import com.tulllenka.wallpaper.ui.component.Header
import com.tulllenka.wallpaper.ui.theme.Colors
import com.tulllenka.wallpaper.ui.theme.Shapes
import com.tulllenka.wallpaper.ui.theme.Typography
import com.tulllenka.wallpaper.utils.InternalStorage
import com.tulllenka.wallpaper.utils.ItemFile
import com.tulllenka.wallpaper.utils.str

@Composable
fun Home() {
    val context = LocalContext.current
    val internalStorage = InternalStorage(context)
    val isOpenDialog = remember {
        mutableStateOf(false)
    }
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) {
        internalStorage.selectedVideo.value = it
        if (it != null) isOpenDialog.value = true
    }

    DialogAdding(
        openDialog = isOpenDialog,
        context = context,
        onClickSave = {
            internalStorage.selectedVideo.value?.let { uri ->
                internalStorage.save(uri, "${uri.lastPathSegment}.mp4" ).let {
                    if (it) internalStorage.listVideos.value += ItemFile(
                        name = "${uri.lastPathSegment}.mp4",
                        thumbnail = internalStorage.getVideoThumbnail(uri)
                    )
                }
            }
            isOpenDialog.value = false
            internalStorage.selectedVideo.value = null
        },
        onClickCancel = {
            internalStorage.selectedVideo.value = null
            isOpenDialog.value = false
        }
    ) {
        internalStorage.selectedVideo.value?.let { uri ->
            internalStorage.getVideoThumbnail(uri).let {
                Image(
                    bitmap = it,
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .clip(Shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${it.width}x${it.height}",
                    fontFamily = Typography.UbuntuMono,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Colors.gray
                )
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.background)
            .systemBarsPadding()
            .padding(bottom = 20.dp)
    ) {
        Header {}

        if (internalStorage.listVideos.value.isNotEmpty()) LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 10.dp,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 20.dp, vertical = 10.dp),) {
            items(internalStorage.listVideos.value) {
                Image(
                    bitmap = it.thumbnail,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(Shapes.medium)
                )
            }
        } else Text(
            text = R.string.notifi.str(),
            fontFamily = Typography.UbuntuMono,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Colors.white,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
        )

        BottomAddButton {
            launcher.launch("video/*")
        }
    }
}