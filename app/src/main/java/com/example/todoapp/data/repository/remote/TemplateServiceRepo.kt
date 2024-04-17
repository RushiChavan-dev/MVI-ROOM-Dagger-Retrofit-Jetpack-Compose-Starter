package com.example.todoapp.data.repository.remote

import com.example.todoapp.data.local.TemplateDao
import com.example.todoapp.data.common.model.Model
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path



interface TemplateServiceRepo {

    suspend fun getUser(userId: String): Model

}