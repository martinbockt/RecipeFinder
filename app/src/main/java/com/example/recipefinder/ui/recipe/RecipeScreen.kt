package com.example.recipefinder.ui.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recipefinder.data.*
import com.example.recipefinder.model.RecipeModel
import com.example.recipefinder.model.SavedRecipe
import com.example.recipefinder.ui.components.Hero

const val ingredientBasePath = "https://spoonacular.com/cdn/ingredients_100x100/"

@Composable
fun RecipeScreen(navController: NavHostController, recipeViewModel: RecipeViewModel, recipeID: Int, apiCall: Boolean) {
    var recipe by remember { mutableStateOf(value = listOf<RecipeModel>()) }
    val recipeAvailable = recipeViewModel.getSingle(recipeID.toString())
    val availabe by recipeViewModel.eventSingle!!.observeAsState()

    if (apiCall) {
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val recipeCall = serviceGenerator.getRecipeById(recipeID)
        enqueueRecipeAPI(recipeCall) {
            recipe = listOf(it)
        }
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items (recipe) { recipe ->
            Box {
                Hero(recipe)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Previous Screen")
                    }
                    IconButton(onClick = {
                        val saveRecipe = SavedRecipe(
                            id = recipe.id,
                            title = recipe.title,
                            readyInMinutes = recipe.readyInMinutes,
                            image = recipe.image
                        )
                        if (availabe != null) {
                            recipeViewModel.deleteRecipe(recipe = saveRecipe)
                        } else {
                            recipeViewModel.addRecipe(recipe = saveRecipe)
                        }
                    }) {
                        if (availabe != null) {
                            Icon(Icons.Rounded.Favorite, contentDescription = "Save Recipe")
                        } else {
                            Icon(Icons.Rounded.FavoriteBorder, contentDescription = "Remove Recipe")
                        }
                    }
                }
            }
        }
        items (recipe) { recipe ->
            RecipeTags(recipe)
        }
        items (recipe) { recipe ->
            RecipeIngredients(recipe)
        }
        items (recipe) { recipe ->
            recipeInstructions(recipe)
        }
    }
}