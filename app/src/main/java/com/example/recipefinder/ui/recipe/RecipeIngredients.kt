package com.example.recipefinder.ui.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipefinder.data.Ingredient
import com.example.recipefinder.data.RecipeModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecipeIngredients(recipe: RecipeModel) {
    Column(
        Modifier.padding(start = 16.dp, end = 8.dp)
    ) {
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            recipe.extendedIngredients.forEach {
                ingredient ->
                Box(modifier = Modifier.fillMaxWidth(0.3333333f)){
                    Card(modifier = Modifier.fillMaxWidth().padding(end = 8.dp, bottom = 8.dp)) {
                        Column(){
                            AsyncImage(
                                model = ingredientBasePath + ingredient.image,
                                contentDescription = recipe.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clip(MaterialTheme.shapes.medium),
                                contentScale = ContentScale.Crop
                            )
                            Column(modifier = Modifier.padding(6.dp)) {
                                Text(
                                    text = ingredient.name,
                                    style = MaterialTheme.typography.labelMedium
                                )
                                Text(
                                    text = "${ingredient.measures.metric.amount} ${ingredient.measures.metric.unitShort}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}