package github.akash1047.rescuebharat

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import github.akash1047.rescuebharat.model.screens.signin.SignInScreen
import github.akash1047.rescuebharat.model.screens.signup.SignUpScreen
import github.akash1047.rescuebharat.model.screens.splash.SplashScreen
import github.akash1047.rescuebharat.ui.theme.RescueBharatTheme

@Composable
fun MainApp() {
    RescueBharatTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val appState = rememberAppState()

            Scaffold { innerPaddingModifier ->
                NavHost(
                    navController = appState.navController,
                    startDestination = SPLASH_SCREEN,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    noteGraph(appState)
                }
            }
        }
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        NotesAppState(navController)
    }

fun NavGraphBuilder.noteGraph(appState: NotesAppState) {
    // add that activity that will be forwarded after the login completed
    composable(MAIN_SCREEN/* TODO: add the app screen */) { /* TODO: add the starting screen activity navigation route */ }

    composable(SIGN_IN_SCREEN) {
        SignInScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(SIGN_UP_SCREEN) {
        SignUpScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(SPLASH_SCREEN) {
        SplashScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }
}