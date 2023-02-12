package com.example.recipefinder.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("/recipes/random?apiKey=45e0b13dff70469daeac6e4c793db684&limitLicense=true&number=10")
    fun getRandomRecipes(): Call<MutableList<RecipeModel>>

    @GET("/recipes/716429/information?apiKey=45e0b13dff70469daeac6e4c793db684&includeNutrition=false")
    fun getRecipe(): Call<RecipeModel>
}