package com.example.recipefinder

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

interface Destination {
    val name: String
    val icon: ImageVector
    val route: String
}

/**
 * Recipefinder app navigation destinations
 */
object Home : Destination {
    override val name = "Home"
    override val icon = Icons.Filled.Home
    override val route = "home"
}

object Search : Destination {
    override val name = "Search"
    override val icon = Icons.Filled.Search
    override val route = "search"
}

object Recipe : Destination {
    override val name = "Recipe"
    override val icon = Icons.Filled.Favorite
    override val route = "recipe/{recipeID}/{apiCall}"
}

object  Settings : Destination {
    override val name = "Settings"
    override val icon = Icons.Filled.Settings
    override val route = "settings"
}

val TabRowScreens = listOf(Home, Search)