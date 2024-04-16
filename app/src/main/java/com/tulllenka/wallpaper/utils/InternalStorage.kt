package com.tulllenka.wallpaper.utils

import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.net.toUri
import java.io.File
import java.io.FileOutputStream
import kotlin.coroutines.cancellation.CancellationException

class InternalStorage(private val context: Context) {
    val selectedVideo = mutableStateOf<Uri?>(null)
    val listVideos = mutableStateOf(loadContent())

    fun save(uri: Uri, fileName: String): Boolean {
        context.contentResolver.openInputStream(uri)?.use { input ->
            FileOutputStream(File(context.filesDir, fileName)).use { output ->
                input.copyTo(output)
                return true
            }
        }
        return false
    }

    fun delete(fileName: String): Boolean = File(context.filesDir, fileName).delete()

    fun getAll(): List<File> =
        context.filesDir.listFiles { file ->
            file.isFile && file.extension == "mp4"
        }?.toList() ?: emptyList()

    private fun loadContent(): List<ItemFile> =
        getAll().map { file ->
            ItemFile(file.name, getVideoThumbnail(file.toUri()))
        }

    fun getVideoThumbnail(uri: Uri): ImageBitmap = MediaMetadataRetriever().let {
        it.setDataSource(context, uri)
        return it.getFrameAtTime(0, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)?.asImageBitmap()!!
    }
}

data class ItemFile(
    val name: String,
    val thumbnail: ImageBitmap,
)