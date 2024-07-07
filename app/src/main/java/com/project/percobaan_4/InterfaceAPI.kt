package com.project.percobaan_4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RecipeApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse

    companion object {
        private var retrofitService: RecipeApiService? = null

        fun getInstance(): RecipeApiService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://172.16.1.130:8001/projects/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RecipeApiService::class.java)
            }
            return retrofitService!!
        }
    }
}