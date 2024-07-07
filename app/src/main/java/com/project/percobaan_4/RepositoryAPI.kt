package com.project.percobaan_4

class RecipeRepository(private val apiService: RecipeApiService) {
    suspend fun getRecipes() = apiService.getRecipes()
}