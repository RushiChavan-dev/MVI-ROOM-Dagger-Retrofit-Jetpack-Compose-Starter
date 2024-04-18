package com.example.todoapp.data.repository.room

import com.example.todoapp.data.common.model.NotesModel
import kotlinx.coroutines.flow.Flow


/*
* This Interface is used to call
* the NotesDao Services methods
* it acts like API Services Class
* but from Local Database Room
*
*
*
* */


// Room TemplateRepo Service
interface RoomNotesDaoRepo {
//    fun getAll(): Flow<List<NotesDaoService>>
    suspend fun insertNote(): Unit
    suspend fun getAllNotes():List<NotesModel>
//    fun insertNote() :

}