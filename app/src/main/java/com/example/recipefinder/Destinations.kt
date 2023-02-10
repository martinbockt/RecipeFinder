package com.example.recipefinder

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

interface Destination {
    val icon: ImageVector
    val route: String
}

/**
 * Recipefinder app navigation destinations
 */
object Home : Destination {
    override val icon = Icons.Filled.Home
    override val route = "home"
}

object Search : Destination {
    override val icon = Icons.Filled.Search
    override val route = "search"
}

//object SingleAccount : Destination {
//    override val icon = Icons.Filled.AddCircle
//    override val route = "single_account"
//    const val accountTypeArg = "account_type"
//    val routeWithArgs = "$route/{$accountTypeArg}"
//    val arguments = listOf(
//        navArgument(accountTypeArg) { type = NavType.StringType }
//    )
//    val deepLinks = listOf(
//        navDeepLink { uriPattern = "recipefinder://$route/{$accountTypeArg}" }
//    )
//}

val TabRowScreens = listOf(Home, Search)