package github.akash1047.rescuebharat.citizen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

data class Item(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun BottomBarLayout(
    items: Iterable<Item>,
    destination: NavDestination?,
    onMenuItemSelected: (String) -> Unit,
    content: @Composable (innerPadding: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = destination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = { onMenuItemSelected(item.route) },
                        icon = { Icon(item.icon, null) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}

@Composable
fun NavigationRailLayout(
    items: Iterable<Item>,
    destination: NavDestination?,
    onMenuItemSelected: (String) -> Unit,
    content: @Composable () -> Unit
) {
    Row(Modifier.fillMaxSize()) {
        NavigationRail {
            items.forEach { item ->
                NavigationRailItem(
                    selected = destination?.hierarchy?.any { it.route == item.route } == true,
                    onClick = { onMenuItemSelected(item.route) },
                    icon = { Icon(item.icon, null) },
                    label = { Text(item.label) }
                )
            }
        }

        content()
    }
}