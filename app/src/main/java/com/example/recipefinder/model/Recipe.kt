package com.example.recipefinder.model

data class RecipeModel (
   val vegetarian: Boolean,
    val title: String,
    val id: Int,
    val vegan: Boolean,
    val preparationMinutes: Int,
    val cookingMinutes: Int,
    val healthScore: Int,
    val creditsText: String,
    val sourceName: String,
    val extendedIngredients: List<Ingredient>,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val image: String,
    val imageType: String,
    val summary: String,
    val cuisines: List<String>,
    val dishTypes: List<String>,
    val instructions: String,
    val analyzedInstructions: List<Instruction>,
)

data class Ingredient(
    val id: Int,
    val image: String,
    val name: String,
    val nameClean: String,
    val measures: Measures,
)

data class Measures(
    val metric: Measure,
)

data class Measure(
    val amount: Double,
    val unitShort: String,
)

data class Instruction(
    val number: Int,
    val steps: List<Step>,


)

data class Step(
    val number: Int,
    val step: String,
    val ingredients: List<Ingredient>,


)