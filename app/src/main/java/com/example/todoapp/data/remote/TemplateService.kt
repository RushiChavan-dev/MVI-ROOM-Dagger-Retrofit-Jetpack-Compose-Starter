package com.example.todoapp.data.remote

import com.example.todoapp.data.common.model.Model
import retrofit2.http.GET
import retrofit2.http.Path



// Retrofit Service
interface TemplateService {

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: String): Model

}