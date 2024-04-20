package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.common.model.RetTodo
import com.example.todoapp.data.common.model.Todo
import com.example.todoapp.data.common.model.TodosRetrofitModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


// Retrofit Service
interface APIRetrofitService {

    @GET("todos/")
    suspend fun getAllTodos(): TodosRetrofitModel


    @POST("todos/add")
    suspend fun insertTodos(@Body requestBody: RetTodo): Todo
}