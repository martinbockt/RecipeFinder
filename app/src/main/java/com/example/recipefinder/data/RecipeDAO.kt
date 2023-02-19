package com.example.recipefinder.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.recipefinder.model.SavedRecipe


@Dao
interface RecipeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipe(recipe: SavedRecipe)

    @Query("SELECT * FROM recipes ORDER BY id ASC")
    fun readAllData(): LiveData<List<SavedRecipe>>

    @Query("SELECT * FROM recipes WHERE id=:id ")
    fun loadSingle(id: String): LiveData<SavedRecipe>

    @Delete
    suspend fun deleteRecipe(recipe: SavedRecipe)

    @Query("DELETE FROM recipes")
    suspend fun deleteAllRecipes()
}