package github.akash1047.rescuebharat

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Campaign
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import github.akash1047.rescuebharat.citizen.BottomBarLayout
import github.akash1047.rescuebharat.citizen.GUIDE_SCREEN
import github.akash1047.rescuebharat.citizen.Item
import github.akash1047.rescuebharat.citizen.NavigationRailLayout
import github.akash1047.rescuebharat.citizen.PROFILE_SCREEN
import github.akash1047.rescuebharat.citizen.REPORT_SCREEN
import github.akash1047.rescuebharat.citizen.START_SCREEN
import github.akash1047.rescuebharat.models.screens.CitizenScreens
import github.akash1047.rescuebharat.models.screens.GuideScreen
import github.akash1047.rescuebharat.models.screens.ProfileScreen
import github.akash1047.rescuebharat.citizen.screens.ReportScreen

@Composable
fun CitizenApp(widthSizeClass: WindowWidthSizeClass) {
    val navItems = listOf(
        Item("Guide", Icons.Outlined.LocalLibrary, GUIDE_SCREEN),
        Item("Report", Icons.Outlined.Campaign, REPORT_SCREEN),
        Item("Profile", Icons.Outlined.AccountCircle, PROFILE_SCREEN),
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
    ) {
        val navController = rememberNavController()
        val navBackStackEntry =  navController.currentBackStackEntryAsState().value
        val currentDestination = navBackStackEntry?.destination

        val navHost = remember {
            movableContentOf<PaddingValues> { innerPadding ->
                NavHost(navController, START_SCREEN, modifier = Modifier.padding(innerPadding)) {
                    composable(CitizenScreens.ProfileScreen.name) { ProfileScreen() }
                    composable(CitizenScreens.ReportScreen.name) { ReportScreen() }
                    composable(CitizenScreens.GuideScreen.name) { GuideScreen() }
                }
            }
        }

        when (widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                BottomBarLayout(items = navItems,
                    destination = currentDestination,
                    onMenuItemSelected = { route ->

                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }) { innerPadding ->
                    navHost(innerPadding)
                }
            }

            else -> {
                NavigationRailLayout(items = navItems,
                    destination = currentDestination,
                    onMenuItemSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }) {
                    navHost(PaddingValues())
                }
            }
        }
    }
}
