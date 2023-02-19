package com.example.recipefinder.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recipefinder.data.*
import com.example.recipefinder.model.RecipeModel
import com.example.recipefinder.ui.components.LikedRecipeCard
import com.example.recipefinder.ui.components.RecipeCard
import com.example.recipefinder.ui.search.enqueueRandomAPI

@Composable
fun HomeScreen(navController: NavHostController,
               dataStoreUtil: DataStoreUtil,
               recipeViewModel: RecipeViewModel,
               userLocationCountry: String
) {
    val foodPreference = dataStoreUtil.getFoodPreference("Everything").collectAsState(initial = "Everything").value
    val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
    var listItemsHeroState by remember { mutableStateOf(value = listOf<RecipeModel>()) }
    var listItemsLocationState by remember { mutableStateOf(value = listOf<RecipeModel>()) }
    val likedItems by recipeViewModel.readAllData.observeAsState()

    val listItemsHero = serviceGenerator.getRandomRecipe(
        number = "3",
        tags = if (foodPreference.lowercase() != "everything") foodPreference.lowercase() else null
        )
    enqueueRandomAPI(listItemsHero) {
        listItemsHeroState = it
    }

    val listItems = serviceGenerator.getRandomRecipe(
        number = "10",
        tags = if (foodPreference.lowercase() != "everything") foodPreference.lowercase() + ", " + userLocationCountry else userLocationCountry
    )
    enqueueRandomAPI(listItems) {
        listItemsLocationState = it
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            if (listItemsHeroState.isNotEmpty()) {
                Slider(sliderList = listItemsHeroState) {
                    navController.navigate("${it}/true")
                }
            }
        }
        item {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Liked Recipes",
                    style = MaterialTheme.typography.titleLarge
                )
                if (likedItems?.isEmpty() == true || likedItems == null) {
                    Text(
                        modifier = Modifier.padding(vertical = 12.dp),
                        text = "You have not liked any recipes yet. Start browsing our delicious " +
                                "recipes and save your favorites to this list for easy access later."
                    )
                }
            }
        }
        item {
            LazyRow() {
                items(likedItems ?: emptyList()) { recipe ->
                    LikedRecipeCard(recipe) {
                        navController.navigate("${it}/true")
                    }
                }
            }
        }
        item {
            Text(text = userLocationCountry + "Food",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        items(listItemsLocationState) {recipe ->
            RecipeCard(recipe = recipe) {
                navController.navigate("${it}/true")
            }
        }
    }
}