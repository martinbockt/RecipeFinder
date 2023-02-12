package com.example.recipefinder.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/recipes/random?limitLicense=true&number=10")
    fun getRandomRecipes(): Call<MutableList<RecipeModel>>
}