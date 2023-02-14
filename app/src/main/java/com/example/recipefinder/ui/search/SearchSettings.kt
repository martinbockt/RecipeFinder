package com.example.recipefinder.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSettings(text: String, onInputChange: (String)->Unit) {
    Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Search", style = MaterialTheme.typography.headlineMedium)
            TextField(
                value = text,
                onValueChange = onInputChange
            )
            Text(text = "OR", style = MaterialTheme.typography.labelLarge)
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Get Lucky", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}