package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.common.model.NotesModel


interface TemplateServiceRepo {

    suspend fun getUser(userId: String): NotesModel

}