package com.example.recipefinder.ui.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipefinder.model.RecipeModel

@Composable
fun recipeInstructions(recipe: RecipeModel) {
    Column() {
        Text(
            text = "Instructions",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
        )
        recipe.analyzedInstructions.forEach {it ->
            it.steps.forEach{step ->
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth().padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    step.ingredients.forEach { ingredient ->
                        item {
                            AsyncImage(
                                model = ingredientBasePath + ingredient.image,
                                contentDescription = ingredient.name,
                                modifier = Modifier
                                    .width(80.dp)
                                    .height(80.dp)
                                    .clip(MaterialTheme.shapes.medium)
                            )
                        }
                    }
                }
                Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                    Text(
                        text = step.step,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(6.dp)
                    )
                }
            }
        }
    }
}