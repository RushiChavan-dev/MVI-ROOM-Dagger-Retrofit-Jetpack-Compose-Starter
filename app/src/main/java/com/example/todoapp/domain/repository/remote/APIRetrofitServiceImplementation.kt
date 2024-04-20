package com.example.todoapp.domain.repository.remote

import com.example.todoapp.data.common.model.RetTodo
import com.example.todoapp.data.common.model.Todo
import com.example.todoapp.data.repository.remote.APIRetrofitService
import com.example.todoapp.data.repository.remote.APIAbstractRetrofitServiceRepo
import com.example.todoapp.data.common.model.TodosRetrofitModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class APIRetrofitServiceImplementation @Inject constructor(private val service: APIRetrofitService)  : APIAbstractRetrofitServiceRepo {

    override suspend fun getNotes(): TodosRetrofitModel {
        return service.getAllTodos()
    }

    override suspend fun insertTodoNotes(retTodo : RetTodo): Todo {
        return service.insertTodos(retTodo)
    }

}