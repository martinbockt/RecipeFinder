package com.example.recipefinder.data
import com.example.recipefinder.model.Recipecard
import com.example.recipefinder.R

/**
 * [Datasource] generates a list of [Recipecard]
 */
class Datasource() {
    fun loadRecipes(): List<Recipecard>
    {
        return listOf<Recipecard>(
            Recipecard("Steak", "10 min", false, R.drawable.image01),
            Recipecard("Steak", "10 min", false, R.drawable.image01),
            Recipecard("Steak", "10 min", false, R.drawable.image01),
            Recipecard("Steak", "10 min", false, R.drawable.image01),
            Recipecard("Steak", "10 min", false, R.drawable.image01),
            Recipecard("Kein Steak", "10 min", true, R.drawable.image01),
            Recipecard("Kein Steak", "10 min", true, R.drawable.image01),
            Recipecard("Kein Steak", "10 min", true, R.drawable.image01),
            Recipecard("Kein Steak", "10 min", true, R.drawable.image01),
            Recipecard("Kein Steak", "10 min", true, R.drawable.image01),
        )
    }
}
