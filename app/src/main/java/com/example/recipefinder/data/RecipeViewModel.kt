package com.example.recipefinder.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.recipefinder.model.SavedRecipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<SavedRecipe>>
    private val repository: RecipeRepository
    var eventSingle: LiveData<SavedRecipe>? = null

    init {
        val recipeDAO = RecipeDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(recipeDAO)
        readAllData = repository.readAllData

    }

    fun addRecipe(recipe: SavedRecipe){
       viewModelScope.launch(Dispatchers.IO) {
            repository.addRecipe(recipe)
       }
    }

    fun deleteRecipe(recipe: SavedRecipe){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRecipe(recipe)
        }
    }

    fun deleteAllRecipes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllRecipes()
        }
    }

    fun getSingle(eventId: String) {
        eventSingle = repository.loadSingle(eventId)
    }

}