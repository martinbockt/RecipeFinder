package com.example.recipefinder.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipepreview(val title: String, val duration: String, val vegan: Boolean, @DrawableRes val imageResourceId:Int)
