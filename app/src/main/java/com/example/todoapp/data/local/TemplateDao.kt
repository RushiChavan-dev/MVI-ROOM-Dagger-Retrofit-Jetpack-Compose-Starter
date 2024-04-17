package com.example.todoapp.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


// Room Database Operation
@Dao
interface TemplateDao {

    /*Use this for query*/
    @Query("SELECT * FROM model")
    fun getAll(): Flow<List<TemplateDao>>

}