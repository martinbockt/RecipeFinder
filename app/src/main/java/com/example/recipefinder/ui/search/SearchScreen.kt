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
import androidx.navigation.NavHostController
import com.example.recipefinder.data.*
import com.example.recipefinder.ui.components.RecipeCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController, dataStoreUtil: DataStoreUtil) {
    val openDialog = remember { mutableStateOf(false) }
    val openedDialogOnce = rememberSaveable { mutableStateOf(false) }
    val searchSettings = rememberSaveable(saver = InitialSearchSettingsSaver) { InitialSearchSettings() }
    val foodPreference = dataStoreUtil.getFoodPreference("Everything").collectAsState(initial = "Everything").value

    if (!openedDialogOnce.value) {
        if (foodPreference != "Everything") {
            searchSettings.diet = foodPreference
        }
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false }
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
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CuisineSettings(
                        if (searchSettings.cuisine != null)
                            searchSettings.cuisine!!.split(", ")
                    else
                            searchSettings.excludeCuisine?.split(", ")
                    ) { cuisines, addCuisines ->
                        if (addCuisines) {
                            searchSettings.cuisine = cuisines
                            searchSettings.excludeCuisine = null
                        } else {
                            searchSettings.excludeCuisine = cuisines
                            searchSettings.cuisine = null
                        }
                    }
                    TypeSettings(searchSettings.type?.split(", ")) {
                        searchSettings.type = it
                    }
                    DietSettings(searchSettings.diet?.split(", ")) {
                        searchSettings.diet = it
                    }
                    IntoleranceSettings(searchSettings.intolerances?.split(", ")) {
                        searchSettings.intolerances = it
                    }
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Close")
                    }
                }
            }
        }
    }

    var text by rememberSaveable { mutableStateOf("") }
    val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
    var listItemsState by remember { mutableStateOf(value = listOf<RecipeModel>()) }
    val listItems = serviceGenerator.searchRecipe(
        query = text,
        number = "20",
        cuisine = searchSettings.cuisine,
        excludeCuisine = searchSettings.excludeCuisine,
        diet = searchSettings.diet,
        intolerances = searchSettings.intolerances,
        type = searchSettings.type,
        maxReadyTime = searchSettings.maxReadyTime
    )
    // TODO change query = "steak" to query = text
    enqueueSearchAPI(listItems) {
        listItemsState = it
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            SearchSettings(text = text, toggleDialog = {
                openDialog.value = true
                openedDialogOnce.value = true
                                                       }, getLucky = {
                enqueueRandomAPI(serviceGenerator.getRandomRecipe(tags = searchSettings.diet?.lowercase())) {
                    listItemsState = it
                }
            }) {
                text = it
            }
        }
        items(listItemsState) { recipe ->
            RecipeCard(recipe) {
                navController.navigate("${it}/true")
            }
        }
    }
}

fun filterChipsToString(chipList: List<String>, multipleChecked: Set<Int>): String? {
    var returnChips = ""
    chipList.forEachIndexed { index, chip ->
        if (multipleChecked.contains(index)) returnChips += "${chip}, "
    }
    if (returnChips == "") {
        return null
    }
    return returnChips.dropLast(2)
}