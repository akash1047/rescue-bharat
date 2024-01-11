package github.akash1047.rescuebharat.citizen.screens


import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.MyLocation
import androidx.compose.material.icons.twotone.Image
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult

@Composable
fun ReportScreen() {
    val context = LocalContext.current
    var image = remember{ mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ListItem(
            leadingContent = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Outlined.MyLocation,
                        null
                    )
                }
            },
            headlineContent = { Text("TIB canteen") },
            supportingContent = { Text("lat: 12.5634, long: 72.9101") },
            trailingContent = { Image(Icons.TwoTone.Image, null) }
        )

        Box(
            Modifier
                .fillMaxSize(0.9f)
                .aspectRatio(1f)
                .padding(8.dp)
                .clickable {
                    val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                    try {
                        startActivityForResult(context as Activity, takePictureIntent, 1, null)
                        image.value = takePictureIntent.data
                    } catch (_: ActivityNotFoundException) {
                        Log.i("PHOTO TAKE", "ReportScreen: activity not found")
                    }
                }
        ) {
            Image(Icons.Outlined.Camera, null,
                Modifier
                    .fillMaxSize(0.7f)
                    .align(Alignment.Center))

            if (image.value == null) {
                Text("Take a picture", Modifier.align(Alignment.BottomEnd))
            } else {
                Text("picture is taken", Modifier.align(Alignment.BottomEnd))
            }
        }

        ListItem(
            leadingContent = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Close, null)
                }
            },
            headlineContent = { Text("Submit Report") },
            trailingContent = {
                FilledTonalButton(onClick = { /*TODO*/ }) {
                    Text("Submit")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReportScreenPreview() {
    ReportScreen()
}
