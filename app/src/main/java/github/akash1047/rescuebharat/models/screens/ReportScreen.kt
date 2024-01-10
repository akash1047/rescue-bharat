package github.akash1047.rescuebharat.models.screens


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ReportScreen() {
    Log.i("MOUSE", "ReportScreen: PUSSy")
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Citizen report screen")
    }
}

@Preview(showBackground = true)
@Composable
private fun ReportScreenPreview() {
    ReportScreen()
}
