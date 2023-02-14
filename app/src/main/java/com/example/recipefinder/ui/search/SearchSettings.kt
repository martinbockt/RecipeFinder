package com.example.recipefinder.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSettings(text: String, toggleDialog: ()->Unit, onInputChange: (String)->Unit) {
    Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Search", style = MaterialTheme.typography.headlineMedium)
            OutlinedTextField(
                value = text,
                onValueChange = onInputChange,
                label = { Text("Search for Recipes") },
                placeholder = { Text("Search for Recipes") },
                singleLine = true,
                trailingIcon = {
                    Button(
                        contentPadding = PaddingValues(0.dp),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = MaterialTheme.colorScheme.primary),
                        onClick = toggleDialog
                    ){
                        Icon(Icons.Rounded.Settings, contentDescription = "Localized description")
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        toggleDialog()
                    }
                ),
            )
            Text(text = "OR", style = MaterialTheme.typography.labelLarge)
            Button(
                onClick = {  }
            ) {
                Text(text = "Get Lucky", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}