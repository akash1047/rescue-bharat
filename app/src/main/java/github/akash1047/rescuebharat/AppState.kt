package github.akash1047.rescuebharat

import androidx.compose.runtime.Stable
import androidx.navigation.NavController


@Stable
class AppState(private val navController: NavController) {

    // for exiting the app or so
    fun popUp() {
        navController.popBackStack()
    }

    // for going to a specific Activity with the help of the declared activity
    fun navigate(activityRoutes: String) {
        navController.navigate(activityRoutes) { launchSingleTop = true }
    }

    // from one activity to another activity
    fun navigateAndPopUp(route: String, popUp: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    }
}