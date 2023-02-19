package com.example.recipefinder.ui.settings

import android.widget.GridLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipefinder.data.DataStoreUtil

val data = listOf("Everything", "Vegetarian", "Vegan")

@Composable
fun FoodPreferences(dataStoreUtil: DataStoreUtil, onSelectedFood: (String) -> Unit) {
    val foodPreferences = dataStoreUtil.getFoodPreference("Everything").collectAsState(initial = "Everything").value
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
            .fillMaxWidth()
    ) {
       items(data) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectedFood(it) },
                colors = CardDefaults.cardColors(
                    containerColor = if (foodPreferences == it)
                        MaterialTheme.colorScheme.surfaceTint
                        else
                        MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Box(
                    Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = it)
                }
            }
       }
    }
}