package com.example.recipefinder.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RecipeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipe(recipe: SavedRecipe)

    @Query("SELECT * FROM recipes ORDER BY id ASC")
    fun readAllData(): LiveData<List<SavedRecipe>>

    @Delete
    suspend fun deleteRecipe(recipe: SavedRecipe)

    @Query("DELETE FROM recipes")
    suspend fun deleteAllRecipes()
}