package com.example.todoapp.data.common.model



data class TodosRetrofitModel(
    val todos: List<Todo>,
    val total: Int,
    val skip: Int,
    val limit: Int
)


data class Todo(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)

