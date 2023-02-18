package com.example.recipefinder.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipefinder.data.RecipeModel
import com.example.recipefinder.data.getIcon

@Composable
fun Hero(recipepreview: RecipeModel) {
    Box(Modifier.height(280.dp)) {
        AsyncImage(
            model = recipepreview.image,
            contentDescription = recipepreview.title,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            contentScale = ContentScale.FillBounds,
        )
        Row(
            Modifier.fillMaxWidth().fillMaxHeight().
            background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    280 * 0.5F,
                    280 * 3.5F
                )
            ).padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column() {
                Text(
                    text = recipepreview.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Text(
                    text = recipepreview.readyInMinutes.toString() + " min",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
            }
            Icon(
                getIcon(recipepreview),
                "test",
                tint = Color.White
            )
        }
    }
}



//@Preview
//@Composable
//fun ComposablePreview() {
//    Hero(Recipepreview("Steak", "10 min", false, R.drawable.image01))
//}