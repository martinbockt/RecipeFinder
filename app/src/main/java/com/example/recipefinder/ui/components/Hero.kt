package com.example.recipefinder.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipefinder.R
import com.example.recipefinder.model.Recipepreview

@Composable
fun Hero(recipepreview: Recipepreview) {
    Box(Modifier.height(300.dp)) {
        Image(
            painter = painterResource(id = recipepreview.imageResourceId),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        Row(
            Modifier.fillMaxWidth().fillMaxHeight().
            background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    300 * 0.5F,
                    300 * 3.5F
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
                    text = recipepreview.duration,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
            }
            Icon(
                Icons.Rounded.ShoppingCart,
                "test",
                tint = Color.White
            )
        }
    }
}



@Preview
@Composable
fun ComposablePreview() {
    Hero(Recipepreview("Steak", "10 min", false, R.drawable.image01))
}