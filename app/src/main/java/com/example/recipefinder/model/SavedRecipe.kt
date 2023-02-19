package com.example.recipefinder.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipes")
data class SavedRecipe (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val image: String,
)