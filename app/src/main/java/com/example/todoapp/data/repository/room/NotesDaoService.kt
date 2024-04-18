package com.example.todoapp.data.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoapp.data.common.model.NotesModel
import kotlinx.coroutines.flow.Flow


// Room Database Operation


@Dao
interface NotesDaoService {



    /*
    * Use this for query
    * Define query methods here
    * You can write multiple RoomDB operations in this section
    * Create methods to call Model classes and use them here
    * */
//    @Query("SELECT * FROM notesmodel")
//    fun getAllNote(): Flow<List<NotesModel>>




    @Query("SELECT * FROM NotesModel")
    suspend fun getAllNotes(): List<NotesModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NotesModel)

}