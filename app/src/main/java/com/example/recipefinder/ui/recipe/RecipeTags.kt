package com.example.recipefinder.ui.recipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipefinder.model.RecipeModel

fun getTags(recipe: RecipeModel): MutableList<String> {
    var tags = mutableListOf<String>()
    if (recipe.vegan) {
        tags.add("vegan")
    } else if (recipe.vegetarian) {
        tags.add("vegetarian")
    }
    tags.addAll(recipe.cuisines)
    tags.add("Healthscore: ${recipe.healthScore}")
    return tags
}

@Composable
fun RecipeTags(recipe: RecipeModel) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        getTags(recipe).forEachIndexed { index, s ->
            item {
               AssistChip(
                   label = { Text(text = s) },
                   onClick = {}
               )
            }
        }
    }
}