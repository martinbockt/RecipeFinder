package com.example.recipefinder.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("/recipes/random?apiKey=45e0b13dff70469daeac6e4c793db684&limitLicense=true&number=1")
    fun getRandomRecipe(): Call<RandomRecipeResult>

    @GET("/recipes/{recipeId}/information?apiKey=45e0b13dff70469daeac6e4c793db684&includeNutrition=false")
    fun getRecipeById(@Path("recipeId") recipeId: Int): Call<RecipeModel>

    @GET("/recipes/complexSearch")
    fun searchRecipe(@Query("apiKey") apiKey: String = "45e0b13dff70469daeac6e4c793db684",@Query("query") query: String? = null, @Query("cuisine") cuisine: String? = null, @Query("excludeCuisine") excludeCuisine: String? = null, @Query("diet") diet: String? = null, @Query("intolerances") intolerances: String? = null, @Query("equipment") equipment: String? = null, @Query("type") type: String? = null, @Query("instructionsRequired") instructionsRequired: String = "true", @Query("tags") tags: String? = null, @Query("titleMatch") titleMatch: String? = null, @Query("maxReadyTime") maxReadyTime: String? = null, @Query("sort") sort: String? = null, @Query("number") number: String? = null) : Call<SearchResultModel>

    
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