package com.example.recipefinder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipefinder.R
import com.example.recipefinder.model.Recipecard


@Composable
fun RecipeCard(recipe: Recipecard, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .height(120.dp)) {
        Row(modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(recipe.imageResourceId),
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
                    style = MaterialTheme.typography.titleLarge
                )
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = recipe.duration,
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

@Preview
@Composable
fun ComposablePreview() {
    Recipecard("Steak", "10 min", false, R.drawable.image01)
}