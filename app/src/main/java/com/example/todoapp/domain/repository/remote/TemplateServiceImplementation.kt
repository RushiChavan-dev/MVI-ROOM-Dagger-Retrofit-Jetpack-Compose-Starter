package com.example.todoapp.domain.repository.remote

import com.example.todoapp.data.repository.remote.TemplateService
import com.example.todoapp.data.repository.remote.TemplateServiceRepo
import com.example.todoapp.data.common.model.NotesModel


class TemplateServiceImplementation(private val service: TemplateService)  : TemplateServiceRepo {

    override suspend fun getUser(userId: String): NotesModel {
        TODO("Not yet implemented")
    }

}