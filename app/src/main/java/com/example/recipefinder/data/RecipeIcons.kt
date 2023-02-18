package com.example.recipefinder.data
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

private val FoodMap = mapOf(
    "Asian" to Icons.Rounded.RamenDining,
    "Italian" to Icons.Rounded.DinnerDining,
    "German" to Icons.Rounded.Restaurant,
    "American" to Icons.Rounded.Fastfood,
    "Spain" to Icons.Rounded.Tapas,
    "Turkey" to Icons.Rounded.KebabDining,
    "Burger" to Icons.Rounded.LunchDining,
    "Pizza" to Icons.Rounded.LocalPizza,
    "breakfast" to Icons.Rounded.BreakfastDining,
    "cafe" to Icons.Rounded.LocalCafe,
    "brunch" to Icons.Rounded.BrunchDining,
    "dinner" to Icons.Rounded.DinnerDining,
    "lunch" to Icons.Rounded.LunchDining
)

fun getIcon(recipe: RecipeModel): ImageVector {
    recipe?.cuisines?.forEach {
        if (FoodMap[it] != null) return FoodMap[it]!!
    }
    recipe?.dishTypes?.forEach {
        if (FoodMap[it] != null) return FoodMap[it]!!
    }
    return Icons.Rounded.DinnerDining
}
