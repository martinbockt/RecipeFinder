package com.example.recipefinder.data

import androidx.lifecycle.LiveData

class RecipeRepository(private val recipeDAO: RecipeDAO) {

    val readAllData: LiveData<List<SavedRecipe>> = recipeDAO.readAllData()

    suspend fun addRecipe(recipe: SavedRecipe){
        recipeDAO.addRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: SavedRecipe){
        recipeDAO.deleteRecipe(recipe)
    }

    suspend fun deleteAllRecipes() {
        recipeDAO.deleteAllRecipes()
    }
}