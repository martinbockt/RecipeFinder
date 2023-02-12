package com.example.recipefinder.ui.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.recipefinder.data.Datasource
import com.example.recipefinder.model.Recipepreview
import com.example.recipefinder.ui.components.RecipeCard

@Composable
fun SearchScreen() {
    RecipecardList(recipecardList = Datasource().loadRecipes())
}

@Composable
fun RecipecardList(recipecardList: List<Recipepreview>) {
    LazyColumn() {
        items(recipecardList) { recipe ->
            RecipeCard(recipe)
        }
    }
}