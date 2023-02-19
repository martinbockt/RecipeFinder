package com.example.recipefinder.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipefinder.data.getIcon
import com.example.recipefinder.model.RecipeModel


@Composable
fun RecipeCard(recipe: RecipeModel, modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp, 0.dp)
        .height(120.dp)) {
        Row(modifier.fillMaxHeight().clickable {
            navigateTo("recipe/${recipe.id}")
        }) {
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.title,
                modifier = Modifier
                    .width(160.dp)
                    .clip(MaterialTheme.shapes.large)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.fillMaxHeight().padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = if (recipe.readyInMinutes != 0) recipe.readyInMinutes.toString() + " min" else "",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Icon(
                        getIcon(recipe),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun ComposableRecipePreview() {
////    RecipeCard(Recipepreview("Steak", "10 min", false, R.drawable.image01))
//}