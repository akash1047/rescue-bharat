package github.akash1047.rescuebharat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import github.akash1047.rescuebharat.ui.theme.RescueBharatTheme

class CitizenActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("ANJUM SAYS", "onCreate: bangaya")

        setContent {
            RescueBharatTheme {
                val windowSize = calculateWindowSizeClass(this)
                CitizenApp(windowSize.widthSizeClass)
            }
        }
    }
}