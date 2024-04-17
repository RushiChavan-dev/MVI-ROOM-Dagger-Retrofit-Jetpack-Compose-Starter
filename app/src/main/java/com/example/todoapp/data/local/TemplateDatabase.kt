package com.example.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.common.model.Model


// Room Database Class
/*Enter Data Class Name here -  example : Model*/
@Database(entities = [Model::class], version = 1)
abstract class TemplateDatabase : RoomDatabase() {
    abstract val templateDao: TemplateDao
}