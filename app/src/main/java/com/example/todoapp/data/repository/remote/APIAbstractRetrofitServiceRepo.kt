package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.common.model.TodosRetrofitModel
import kotlinx.coroutines.flow.Flow


interface APIAbstractRetrofitServiceRepo {
    suspend fun getNotes(): Flow<TodosRetrofitModel>

}