package com.tulllenka.wallpaper

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tulllenka.wallpaper.navigation.home.Home

class MainActivity : ComponentActivity() {
    private val selectedMediaUri = mutableStateOf<Uri?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            rememberSystemUiController().setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = false
            )
            Home()
        }
    }
}

/*


override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            rememberSystemUiController().setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = false
            )
//            Navigation()
            SaveMediaScreen(selectedMediaUri, this)
            MediaListScreen(this)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_PICK_MEDIA -> {
                    data?.data?.let { uri ->
                        selectedMediaUri.value = uri
                    }
                }
                REQUEST_CODE_SAVE_MEDIA -> {
                    // Media saved successfully
                    Toast.makeText(this, "Media saved successfully", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



///////////////////////

@Composable
fun SaveMediaScreen(selectedMediaUri: MutableState<Uri?>, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { pickMedia(context) }) {
            Text("Select Media")
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedMediaUri.value?.let { uri ->
            Button(onClick = { saveMedia(uri, context) }) {
                Text("Save Media")
            }
        }
    }
}

private const val REQUEST_CODE_PICK_MEDIA = 1
private const val REQUEST_CODE_SAVE_MEDIA = 2

private fun Context.createSaveMediaIntent(uri: Uri): Intent {
    val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
        addCategory(Intent.CATEGORY_OPENABLE)
        type = "image/* video/*"
        putExtra(Intent.EXTRA_TITLE, "media_file")
        putExtra(DocumentsContract.EXTRA_INITIAL_URI, uri)
    }
    return intent
}

//@Composable
fun pickMedia(context: Context) {
    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
        addCategory(Intent.CATEGORY_OPENABLE)
        type = "image/* video/*"
    }

    // Start activity for result
    val activity = context as Activity
    activity.startActivityForResult(intent, REQUEST_CODE_PICK_MEDIA)
}

fun saveMedia(uri: Uri, context: Context) {
    val intent = context.createSaveMediaIntent(uri)

    // Start activity for result
    val activity = context as Activity
    activity.startActivityForResult(intent, REQUEST_CODE_SAVE_MEDIA)
}

fun getAllMediaFiles(context: Context): List<File> {
    val mediaFiles = mutableListOf<File>()
    val directory = context.filesDir // Or you can specify your own directory

    directory.listFiles()?.let { files ->
        for (file in files) {
            // Add only media files (you may adjust the conditions based on your specific use case)
            if (file.isFile && (file.extension.equals("jpg", true) || file.extension.equals("jpeg", true) || file.extension.equals("png", true) || file.extension.equals("mp4", true))) {
                mediaFiles.add(file)
            }
        }
    }

    return mediaFiles
}

@Composable
fun MediaListScreen(context: Context) {
    val mediaFiles = remember { getAllMediaFiles(context) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (mediaFiles.isNotEmpty()) {
            LazyColumn {
                items(mediaFiles) { file ->
                    Text(file.name)
                }
            }
        } else {
            Text("No media files found")
        }
    }
}
*/