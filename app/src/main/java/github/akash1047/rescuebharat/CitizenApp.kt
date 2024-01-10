package github.akash1047.rescuebharat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import github.akash1047.rescuebharat.ui.theme.RescueBharatTheme

@Composable
fun CitizenApp() {
    RescueBharatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface,
        ) {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = { CitizenNavbar(navController) }
            ) { innerPadding ->
                NavHost(navController, reportScreen, modifier = Modifier.padding(innerPadding)) {
                    composable(profileScreen) { CitizenProfile() }
                    composable(reportScreen) { CitizenReport() }
                    composable(guideScreen) { CitizenGuide() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CitizenAppPreview() {
    CitizenApp()
}
