package com.example.recipefinder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipefinder.R
import com.example.recipefinder.data.RecipeModel
import com.example.recipefinder.model.Recipepreview


@Composable
fun RecipeCard(recipe: RecipeModel, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp, 0.dp)
        .height(120.dp)) {
        Row(modifier.fillMaxHeight()) {
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
                        text = recipe.readyInMinutes.toString() + " min",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Icon(
                        Icons.Rounded.ShoppingCart,
                        contentDescription = "test"
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