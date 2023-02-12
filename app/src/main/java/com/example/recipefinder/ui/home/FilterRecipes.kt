package com.example.recipefinder.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterRecipes(
    chipList: List<String>,
    tempList: Set<Int>
) {
    var multipleChecked by rememberSaveable { mutableStateOf(tempList) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
        chipList.forEachIndexed { index, s ->
            item {
                FilterChip(selected = multipleChecked.contains(index), onClick = {
                    multipleChecked = if (multipleChecked.contains(index))
                        multipleChecked.minus(index)
                    else
                        multipleChecked.plus(index)

                }, label = {
                    Text(text = s)
                },
                    leadingIcon = {
                        (if (multipleChecked.contains(index)) Icons.Default.Check else null)?.let {
                            Icon(
                                it,
                                contentDescription = "checked"
                            )
                        }
                    }
                )
            }
        }
    }
}