package com.example.recipefinder.data
import com.example.recipefinder.R
import com.example.recipefinder.model.Recipepreview

/**
 * [Datasource] generates a list of [Recipepreview]
 */
class Datasource() {
    fun loadRecipes(): List<Recipepreview>
    {
        return listOf<Recipepreview>(
            Recipepreview("Steak", "10 min", false, R.drawable.image01),
            Recipepreview("Steak", "10 min", false, R.drawable.image01),
            Recipepreview("Steak", "10 min", false, R.drawable.image01),
            Recipepreview("Steak", "10 min", false, R.drawable.image01),
            Recipepreview("Steak", "10 min", false, R.drawable.image01),
            Recipepreview("Kein Steak", "10 min", true, R.drawable.image01),
            Recipepreview("Kein Steak", "10 min", true, R.drawable.image01),
            Recipepreview("Kein Steak", "10 min", true, R.drawable.image01),
            Recipepreview("Kein Steak", "10 min", true, R.drawable.image01),
            Recipepreview("Kein Steak", "10 min", true, R.drawable.image01),
        )
    }
}
