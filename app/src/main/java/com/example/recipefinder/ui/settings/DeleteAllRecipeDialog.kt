package com.example.recipefinder.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteAllRecipeDialog(onCloseDialog: (Boolean) -> Unit, onConfirmDialog: (Boolean) -> Unit) {
    AlertDialog(onDismissRequest = { onCloseDialog(false) }) {
        Surface(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.large
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Confirm Deletion",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Are you sure you want to delete your list of all " +
                            "liked recipes? This action cannot be undone.",
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            onCloseDialog(false)
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = {
                            onConfirmDialog(false)
                        },
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}