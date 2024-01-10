package github.akash1047.rescuebharat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CitizenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CitizenApp() }
    }
}