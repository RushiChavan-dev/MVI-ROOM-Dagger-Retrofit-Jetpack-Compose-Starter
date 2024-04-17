package com.example.todoapp.data.repository.room

import com.example.todoapp.data.local.TemplateDao
import com.example.todoapp.data.common.model.Model
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path


// Room TemplateRepo Service
interface TemplateRepo {


    fun getAll(): Flow<List<TemplateDao>>

}