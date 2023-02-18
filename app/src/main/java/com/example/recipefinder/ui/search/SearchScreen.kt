package com.example.recipefinder.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipefinder.data.*
import com.example.recipefinder.ui.components.RecipeCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    var openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Cuisine"
                    )
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }

    var text by rememberSaveable { mutableStateOf("") }
    val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
    var listItemsState by remember { mutableStateOf(value = listOf<RecipeModel>()) }
    val listItems = serviceGenerator.searchRecipe(query = "steak", number = "20")
    // TODO change query = "steak" to query = text
    enqueueAPI(listItems) {
        listItemsState = it
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            SearchSettings(text = text, toggleDialog = {openDialog.value = true}) {
                text = it
            }
        }
        items(listItemsState) { recipe ->
            RecipeCard(recipe)
        }
    }
}