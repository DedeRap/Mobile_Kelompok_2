package com.project.percobaan_4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    private val repository = RecipeRepository(RecipeApiService.getInstance())

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> get() = _recipes

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            try {
                val response = repository.getRecipes()
                _recipes.value = response.recipes
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}