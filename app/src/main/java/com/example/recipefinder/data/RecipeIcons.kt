package com.example.recipefinder.data
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.recipefinder.model.RecipeModel

private val FoodMap = mapOf(
    "asian" to Icons.Rounded.RamenDining,
    "italian" to Icons.Rounded.DinnerDining,
    "german" to Icons.Rounded.Restaurant,
    "american" to Icons.Rounded.Fastfood,
    "spain" to Icons.Rounded.Tapas,
    "turkey" to Icons.Rounded.KebabDining,
    "burger" to Icons.Rounded.LunchDining,
    "pizza" to Icons.Rounded.LocalPizza,
    "breakfast" to Icons.Rounded.BreakfastDining,
    "cafe" to Icons.Rounded.LocalCafe,
    "brunch" to Icons.Rounded.BrunchDining,
    "dinner" to Icons.Rounded.DinnerDining,
    "lunch" to Icons.Rounded.LunchDining
)

fun getIcon(recipe: RecipeModel): ImageVector {
    recipe?.cuisines?.forEach {
        if (FoodMap[it.lowercase()] != null) return FoodMap[it.lowercase()]!!
    }
    recipe?.dishTypes?.forEach {
        if (FoodMap[it.lowercase()] != null) return FoodMap[it.lowercase()]!!
    }
    return Icons.Rounded.DinnerDining
}
