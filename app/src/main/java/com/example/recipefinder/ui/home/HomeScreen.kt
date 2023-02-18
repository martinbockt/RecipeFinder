package com.example.recipefinder.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.recipefinder.data.Datasource
import com.example.recipefinder.model.Recipepreview
import com.example.recipefinder.ui.components.RecipeCard

@Composable
fun HomeScreen() {
    RecipecardList(
        recipecardList = Datasource().loadRecipes()
    )
}

@Composable
fun RecipecardList(recipecardList: List<Recipepreview>) {
    val originalChips by remember {
        mutableStateOf(
            listOf(
                "chip1",
                "chip2",
                "chip3",
                "chip4",
                "chip5"
            )
        )
    }
    val temp: Set<Int> = emptySet()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            Slider(recipepreview = Datasource().loadRecipes().first())
        }
        item {
            FilterRecipes(chipList = originalChips, tempList = temp)
        }
//        items(recipecardList) { recipe ->
//            RecipeCard(recipe)
//        }
    }
}