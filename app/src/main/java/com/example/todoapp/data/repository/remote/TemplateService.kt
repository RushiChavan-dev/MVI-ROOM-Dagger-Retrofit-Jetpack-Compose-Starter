package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.common.model.NotesModel
import retrofit2.http.GET
import retrofit2.http.Path



// Retrofit Service
interface TemplateService {

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: String): NotesModel

}