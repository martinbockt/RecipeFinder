package com.example.recipefinder

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipefinder.data.DataStoreUtil
import com.example.recipefinder.data.RecipeViewModel
import com.example.recipefinder.data.ThemeViewModel
import com.example.recipefinder.ui.home.HomeScreen
import com.example.recipefinder.ui.recipe.RecipeScreen
import com.example.recipefinder.ui.search.SearchScreen
import com.example.recipefinder.ui.settings.SettingsScreen

@Composable
fun RecipefinderNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    dataStoreUtil: DataStoreUtil,
    themeViewModel: ThemeViewModel,
    recipeViewModel: RecipeViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen(navController, dataStoreUtil, recipeViewModel)
        }
        composable(route = Search.route) {
            SearchScreen(navController, dataStoreUtil, recipeViewModel)
        }
        composable(route = Recipe.route) {
                backStackEntry ->
            val recipeID = backStackEntry.arguments?.getString("recipeID")
            val apiCall = backStackEntry.arguments?.getString("apiCall")
            if (recipeID != "" && apiCall != "") {
                RecipeScreen(navController, recipeViewModel, recipeID!!.toInt(), apiCall!!.toBoolean())
            }
        }
        composable(route = Settings.route) {
            SettingsScreen(dataStoreUtil, themeViewModel, recipeViewModel)
        }
    }
}