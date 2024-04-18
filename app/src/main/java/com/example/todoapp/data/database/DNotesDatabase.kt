package com.example.todoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.common.model.NotesModel
import com.example.todoapp.data.repository.room.NotesDaoService

// This is the Database Class
// This Create Room Database
// Room Database Class
/*Enter Data Class Name here -  example : Model*/
@Database(entities = [NotesModel::class]/*You can add more tables here*/, version = 1)
abstract class DNotesDatabase : RoomDatabase() {
    // notesDao is referring to the NotesModel in the common.model folder
    abstract val notesDao: NotesDaoService

    /*
    * Here you can create more abstract variable indicating
    * to the tables the more tables
    * you will hav ethe more methods will be here
    * */
}