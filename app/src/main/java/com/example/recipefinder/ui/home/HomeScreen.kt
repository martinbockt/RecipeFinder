package com.example.recipefinder.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.recipefinder.data.Datasource
import com.example.recipefinder.model.Recipecard
import com.example.recipefinder.ui.components.RecipeCard

@Composable
fun HomeScreen() {
    RecipecardList(recipecardList = Datasource().loadRecipes())
}

@Composable
fun RecipecardList(recipecardList: List<Recipecard>) {
    LazyColumn() {
        items(recipecardList) { recipe ->
            RecipeCard(recipe)
        }
    }
}