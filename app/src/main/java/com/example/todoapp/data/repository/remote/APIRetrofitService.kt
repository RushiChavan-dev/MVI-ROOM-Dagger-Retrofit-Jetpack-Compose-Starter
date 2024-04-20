package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.common.model.TodosRetrofitModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


// Retrofit Service
interface APIRetrofitService {

    @GET("todos/")
    suspend fun getAllTodos(): Flow<TodosRetrofitModel>

}