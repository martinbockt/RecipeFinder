package com.example.recipefinder.ui.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.example.recipefinder.data.*
import com.example.recipefinder.model.Recipepreview
import com.example.recipefinder.ui.components.LikedRecipeCard
import com.example.recipefinder.ui.components.RecipeCard
import com.example.recipefinder.ui.search.enqueueRandomAPI

@Composable
fun HomeScreen(navController: NavHostController, dataStoreUtil: DataStoreUtil, recipeViewModel: RecipeViewModel) {
    val foodPreference = dataStoreUtil.getFoodPreference("Everything").collectAsState(initial = "Everything").value
    val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
    var listItemsHeroState by remember { mutableStateOf(value = listOf<RecipeModel>()) }

    val listItemsHero = serviceGenerator.getRandomRecipe(
        number = "3",
        tags = if (foodPreference.lowercase() != "everything") foodPreference.lowercase() else null
        )
    enqueueRandomAPI(listItemsHero) {
        listItemsHeroState = it
    }
    val likedItems by recipeViewModel.readAllData.observeAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            Slider(sliderList = listItemsHeroState) {
                navController.navigate("${it}/true")
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

//        item {
//            FilterRecipes(chipList = originalChips, tempList = temp)
//        }
//        items(recipecardList) { recipe ->
//            RecipeCard(recipe)
//        }
    }
}