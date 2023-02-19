package com.example.recipefinder.data

import com.example.recipefinder.model.RecipeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/recipes/random?apiKey=074b0d19bf4e442fbc4bd114bb2ff636&limitLicense=true")
    fun getRandomRecipe(@Query("number") number: String = "10", @Query("tags") tags: String? = null): Call<RandomRecipeResult>

    @GET("/recipes/{recipeId}/information?apiKey=074b0d19bf4e442fbc4bd114bb2ff636&includeNutrition=false")
    fun getRecipeById(@Path("recipeId") recipeId: Int): Call<RecipeModel>

    @GET("/recipes/complexSearch")
    fun searchRecipe(@Query("apiKey") apiKey: String = "074b0d19bf4e442fbc4bd114bb2ff636",@Query("query") query: String? = null, @Query("cuisine") cuisine: String? = null, @Query("excludeCuisine") excludeCuisine: String? = null, @Query("diet") diet: String? = null, @Query("intolerances") intolerances: String? = null, @Query("equipment") equipment: String? = null, @Query("type") type: String? = null, @Query("instructionsRequired") instructionsRequired: String = "true", @Query("tags") tags: String? = null, @Query("titleMatch") titleMatch: String? = null, @Query("maxReadyTime") maxReadyTime: String? = null, @Query("sort") sort: String? = null, @Query("number") number: String? = null) : Call<SearchResultModel>

    
}

data class RandomRecipeResult(
    val recipes: List<RecipeModel>,
)
data class SearchResultModel(
    val results: List<RecipeModel>,
    val offset: Int,
    val number: Int,
    val totalResults: Int,
)

data class SearchResultRecipe(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
)