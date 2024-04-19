package com.example.todoapp.ui.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.common.model.NotesModel
import com.example.todoapp.domain.repository.localroom.RoomNotesServicesImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject



@HiltViewModel
class TodoViewModel @Inject constructor(
    private val roomNotesServices: RoomNotesServicesImplementation
) : ViewModel() {

    private val _notes = MutableStateFlow<List<NotesModel>>(emptyList()) // Assuming Note is the type of your notes
    val notes: StateFlow<List<NotesModel>> = _notes.asStateFlow()

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch{
            getNotes()
        }
    }

    // As this insertNote Method is private
    // To call this method we have to create another method
    private suspend fun insertNote(notesModel: NotesModel) {
        roomNotesServices.insertNote(notesModel)
    }

    // Example of another function that calls insertNote
    suspend fun saveNote(title: String, description: String) {
        val note = NotesModel(0,title,  description)
        insertNote(note)
    }

    private suspend fun getNotes()  {
         roomNotesServices.getAllNotes().collect{response  ->
            _notes.emit(response)
        }

    }

/*
    suspend fun getNotesReturn() : List<NotesModel> {
        var response =  roomNotesServices.getAllNotes()
        Log.d("TAG", "loadResponse: $response ")
    }
*/


}