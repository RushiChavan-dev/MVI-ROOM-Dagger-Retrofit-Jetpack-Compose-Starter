package com.example.todoapp.domain.repository.localroom

import com.example.todoapp.data.local.TemplateDao
import com.example.todoapp.data.repository.room.TemplateRepo
import kotlinx.coroutines.flow.Flow


// Room Implementation
class TemplateRepoImplementation(private val templateDao :TemplateDao) : TemplateRepo {

    override fun getAll(): Flow<List<TemplateDao>> {
        return templateDao.getAll()

    }
}