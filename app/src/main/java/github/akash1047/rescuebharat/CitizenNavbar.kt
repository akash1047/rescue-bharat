package github.akash1047.rescuebharat

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import github.akash1047.rescuebharat.models.screens.CitizenScreens


private data class Item(
    val label: String,
    val icon: ImageVector,
    val route: String,
)

private val items = arrayOf(
    Item("Guide", Icons.Outlined.LocalLibrary, CitizenScreens.GuideScreen.name),
    Item("Report", Icons.Filled.Campaign, CitizenScreens.ReportScreen.name),
    Item("Profile", Icons.Outlined.AccountCircle, CitizenScreens.ProfileScreen.name),
)

@Composable
fun CitizenNavbar(navController: NavController = rememberNavController()) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
                icon = { Icon(item.icon, null) },
                label = { Text(item.label) }
            )
        }
    }
}

@Composable
fun AltCitizenNavbar(navController: NavController = rememberNavController()) {
    Row(Modifier.fillMaxSize()) {
        NavigationRail {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { item ->
                NavigationRailItem(
                    selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },
                    icon = { Icon(item.icon, null) },
                    label = { Text(item.label) }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CitizenNavbarPreview() {
    CitizenNavbar()
}

@Preview(showBackground = true, device = "spec:parent=pixel_5,orientation=landscape")
@Composable
private fun AltCitizenNavbarPreview() {
    AltCitizenNavbar()
}
