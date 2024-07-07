package com.project.percobaan_4

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: String
)

data class RecipeResponse(
    val recipes: List<Recipe>
)