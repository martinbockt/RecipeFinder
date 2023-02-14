package com.example.recipefinder

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipefinder.data.DataStoreUtil
import com.example.recipefinder.data.ThemeViewModel
import com.example.recipefinder.ui.home.HomeScreen
import com.example.recipefinder.ui.search.SearchScreen
import com.example.recipefinder.ui.settings.SettingsScreen

@Composable
fun RecipefinderNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    dataStoreUtil: DataStoreUtil,
    themeViewModel: ThemeViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen()
        }
        composable(route = Search.route) {
            SearchScreen()
        }
        composable(route = Recipe.route) {

        }
        composable(route = Settings.route) {
            SettingsScreen(dataStoreUtil, themeViewModel)
        }
    }
}

//fun NavHostController.navigateSingleTopTo(route: String) =
//    this.navigate(route) {
//        popUpTo(
//            this@navigateSingleTopTo.graph.findStartDestination().id
//        ) {
//            saveState = true
//        }
//        launchSingleTop = true
//        restoreState = true
//    }

//private fun NavHostController.navigateToSingleAccount(accountType: String) {
//    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
//}