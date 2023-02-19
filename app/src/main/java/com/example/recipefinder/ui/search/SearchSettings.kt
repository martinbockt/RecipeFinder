package com.example.recipefinder.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSettings(text: String, toggleDialog: ()->Unit, getLucky: () -> Unit, onInputChange: (String)->Unit) {
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
                    IconButton(onClick = { toggleDialog()}) {
                        Icon(
                            Icons.Rounded.Settings,
                            contentDescription = "Search Settings",)
                    }
                },
            )
            Text(text = "OR", style = MaterialTheme.typography.labelLarge)
            Button(
                onClick = { getLucky() }
            ) {
                Text(text = "Get Lucky", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RenderChip(multipleChecked: Set<Int>, chip: String, index: Int, onFilterClick: (Set<Int>) -> Unit) {
    FilterChip(
        selected = multipleChecked.contains(index),
        onClick = {
             if (multipleChecked.contains(index)) {
                 onFilterClick(multipleChecked.minus(index))
             } else {
                 onFilterClick(multipleChecked.plus(index))
             }},
        label = {
            Text(text = chip.uppercase())
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

@Composable
private fun RenderSettings(currentList: List<String>?, title: String, chips: List<String>, onSettingsChange: (String?) -> Unit) {
    var multipleChecked by rememberSaveable { mutableStateOf(emptySet<Int>()) }
    var loaded by rememberSaveable { mutableStateOf(false) }
    if (!loaded) {
        chips.forEachIndexed { index, element ->
            if (currentList?.contains(element) == true) multipleChecked = multipleChecked.plus(index)
        }
    }

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        chips.forEachIndexed { index, chip ->
            item {
                RenderChip(multipleChecked, chip, index) {
                    loaded = true
                    multipleChecked = it
                    onSettingsChange(filterChipsToString(chips, it))
                }
            }
        }
    }
}

@Composable
fun CuisineSettings(currentList: List<String>?, onCuisineChange: (String?, Boolean) -> Unit) {
    val chipList = listOf(
        "Asian",
        "American",
        "Mexican",
        "German",
        "Caribbean",
        "Chinese",
        "Greek",
        "Vietnamese"
    )
    var multipleChecked by rememberSaveable { mutableStateOf(emptySet<Int>()) }
    var addCuisines by rememberSaveable { mutableStateOf(true) }
    var expanded by remember { mutableStateOf(false) }
    var loaded by rememberSaveable { mutableStateOf(false) }
    if (!loaded) {
        chipList.forEachIndexed { index, element ->
            if (currentList?.contains(element) == true) multipleChecked =
                multipleChecked.plus(index)
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Cuisines", style = MaterialTheme.typography.titleMedium)
        Box {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    if (addCuisines) Icons.Default.Add else Icons.Default.Remove,
                    contentDescription = "Localized description")
            }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                text = { Text("Include") },
                onClick = {
                    addCuisines = true
                    onCuisineChange(filterChipsToString(chipList, multipleChecked), addCuisines)
                    expanded = false},
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Add,
                        contentDescription = "Include selected Cuisines"
                    )
                })
            DropdownMenuItem(
                text = { Text("Exclude") },
                onClick = {
                    addCuisines = false
                    onCuisineChange(filterChipsToString(chipList, multipleChecked), addCuisines)
                    expanded = false},
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Remove,
                        contentDescription = "Exclude selected Cuisines"
                    )
                })
        }}
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        chipList.forEachIndexed { index, chip ->
            item {
                RenderChip(multipleChecked, chip, index) {
                    loaded = true
                    multipleChecked = it
                    onCuisineChange(filterChipsToString(chipList, multipleChecked), addCuisines)
                }
            }
        }
    }
}

@Composable
fun TypeSettings(currentList: List<String>?, onTypeChange: (String?) -> Unit) {
    RenderSettings(
        currentList,
        "Types",
        listOf(
            "main course",
            "side dish",
            "dessert",
            "appetizer",
            "breakfast",
            "snack",
        ),
        onTypeChange
    )
}

@Composable
fun DietSettings(currentList: List<String>?, onDietChange: (String?) -> Unit) {
    RenderSettings(
        currentList,
        "Diets",
        listOf(
            "Vegetarian",
            "Vegan",
            "Ketogenic",
            "Lacto-Vegetarian",
            "Ovo-Vegetarian",
            "Pescetarian",
            "Paleo",
            "Primal"
        ),
        onDietChange
    )
}

@Composable
fun IntoleranceSettings(currentList: List<String>?, onIntoleranceChange: (String?) -> Unit) {
    RenderSettings(
        currentList,
        "Intolerances",
        listOf(
            "Gluten",
            "Grain",
            "Dairy",
            "Egg",
            "Peanut",
            "Seafood",
            "Sesame",
            "Shellfish",
            "Soy",
            "Sulfite",
            "Tree Nut",
            "Wheat"
        ),
        onIntoleranceChange
    )
}