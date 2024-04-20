package com.example.todoapp.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.common.model.NotesModel
import com.example.todoapp.data.common.model.TodosRetrofitModel
import com.example.todoapp.domain.repository.localroom.RoomNotesServicesImplementation
import com.example.todoapp.domain.repository.remote.APIRetrofitServiceImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class TodoViewModel @Inject constructor(
    private val roomNotesServices: RoomNotesServicesImplementation,
    private val retrofitServiceImplementation: APIRetrofitServiceImplementation
) : ViewModel() {


    // For Room Database response
    private val _notes = MutableStateFlow<List<NotesModel>>(emptyList()) // Assuming Note is the type of your notes
    val notes: StateFlow<List<NotesModel>> = _notes.asStateFlow()


    // For Retrofit Model,/ Remote server
    private val _todosResponse = MutableStateFlow<TodosRetrofitModel?>(null)
    val todosResponse: StateFlow<TodosRetrofitModel?> = _todosResponse.asStateFlow()



    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch{
            getRemoteTodos()
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

    private suspend fun getRemoteTodos(){

      retrofitServiceImplementation.getNotes().collect{response->
          // We can emit the response from here to anywhere
          _todosResponse.emit(response)

        }


    }


    /*
    * Retrofit Call Start Here
    * */


}