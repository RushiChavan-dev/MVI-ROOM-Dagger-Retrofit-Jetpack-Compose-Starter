package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.common.model.RetTodo
import com.example.todoapp.data.common.model.Todo
import com.example.todoapp.data.common.model.TodosRetrofitModel


interface APIAbstractRetrofitServiceRepo {
    suspend fun getNotes(): TodosRetrofitModel
    suspend fun insertTodoNotes(retTodo:RetTodo): Todo

}