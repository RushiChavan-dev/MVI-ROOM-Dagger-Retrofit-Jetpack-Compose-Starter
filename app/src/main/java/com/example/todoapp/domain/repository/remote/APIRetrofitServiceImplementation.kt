package com.example.todoapp.domain.repository.remote

import com.example.todoapp.data.repository.remote.APIRetrofitService
import com.example.todoapp.data.repository.remote.APIAbstractRetrofitServiceRepo
import com.example.todoapp.data.common.model.TodosRetrofitModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class APIRetrofitServiceImplementation @Inject constructor(private val service: APIRetrofitService)  : APIAbstractRetrofitServiceRepo {

    override suspend fun getNotes(): Flow<TodosRetrofitModel> {
       return service.getAllTodos()
    }

}