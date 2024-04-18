package com.example.todoapp.ui.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.common.model.NotesModel
import com.example.todoapp.domain.repository.localroom.RoomNotesServicesImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject



@HiltViewModel
class TodoViewModel @Inject constructor(
    private val roomNotesServices: RoomNotesServicesImplementation

) : ViewModel() {

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch{
            insertNote()
            getNotes()
        }
    }

    private suspend fun insertNote() {
        roomNotesServices.insertNote()
    }
    private suspend fun getNotes()  {
        val response =  roomNotesServices.getAllNotes()
        Log.d("TAG", "loadResponse: $response ")
    }

/*
    suspend fun getNotesReturn() : List<NotesModel> {
        var response =  roomNotesServices.getAllNotes()
        Log.d("TAG", "loadResponse: $response ")
    }
*/


}