package com.example.recipefinder.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RecipeRepository(private val recipeDAO: RecipeDAO) {

    val readAllData: LiveData<List<SavedRecipe>> = recipeDAO.readAllData()


    suspend fun addRecipe(recipe: SavedRecipe){
        recipeDAO.addRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: SavedRecipe){
        recipeDAO.deleteRecipe(recipe)
    }

    fun loadSingle(eventId: String): LiveData<SavedRecipe> {
        return recipeDAO.loadSingle(eventId)
    }

    suspend fun deleteAllRecipes() {
        recipeDAO.deleteAllRecipes()
    }
}