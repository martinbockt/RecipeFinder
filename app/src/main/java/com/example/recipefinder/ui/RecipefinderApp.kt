package com.example.recipefinder.ui

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import com.example.recipefinder.data.Datasource
import com.example.recipefinder.model.Recipecard
import com.example.recipefinder.ui.components.RecipeCard
import com.example.recipefinder.ui.theme.RecipeFinderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipefinderApp() {
    RecipeFinderTheme() {
        Scaffold(
            content = { innerPadding -> RecipecardList(recipecardList = Datasource().loadRecipes(), innerPadding) }
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecipecardList(recipecardList: List<Recipecard>, innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier.consumeWindowInsets(innerPadding),
        contentPadding = innerPadding
    ) {
        items(recipecardList) { recipe ->
            RecipeCard(recipe)
        }
    }
}

