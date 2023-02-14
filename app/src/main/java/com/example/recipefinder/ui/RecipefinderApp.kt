package com.example.recipefinder.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.*
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipefinder.*
import com.example.recipefinder.data.DataStoreUtil
import com.example.recipefinder.data.ThemeViewModel
import com.example.recipefinder.ui.theme.RecipeFinderTheme

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        name = Home.name,
        route = Home.route,
        icon = Home.icon,
    ),
    BottomNavItem(
        name = Search.name,
        route = Search.route,
        icon = Search.icon,
    ),
    BottomNavItem(
        name = Settings.name,
        route = Settings.route,
        icon = Settings.icon,
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipefinderApp(
    theme: State<Boolean>,
    dataStoreUtil: DataStoreUtil,
    themeViewModel: ThemeViewModel
) {

    RecipeFinderTheme(
        darkTheme = theme.value,
        ) {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            TabRowScreens.find { it.route == currentDestination?.route } ?: Home
        val backStackEntry = navController.currentBackStackEntryAsState()

        Scaffold(
            bottomBar =  {
                NavigationBar() {
                    bottomNavItems.forEach { item ->
                        val selected = item.route == backStackEntry.value?.destination?.route

                        NavigationBarItem(
                            selected = selected,
                            onClick = { navController.navigate(item.route) },
                            label = {
                                Text(
                                    text = item.name,
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "${item.name} Icon",
                                )
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            RecipefinderNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                dataStoreUtil,
                themeViewModel
            )
        }
    }
}

