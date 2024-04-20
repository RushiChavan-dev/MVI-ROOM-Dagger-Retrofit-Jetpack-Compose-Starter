package com.example.todoapp.ui.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.common.model.NotesModel
import com.example.todoapp.data.common.model.RetTodo
import com.example.todoapp.data.common.model.Todo
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
    private val roomNotesServicesImplementation: RoomNotesServicesImplementation,
    private val retrofitServiceImplementation: APIRetrofitServiceImplementation
) : ViewModel() {


    // For Room Database response
    private val _notes = MutableStateFlow<List<NotesModel>>(emptyList()) // Assuming Note is the type of your notes
    val notes: StateFlow<List<NotesModel>> = _notes.asStateFlow()


    // For Retrofit Model,/ from Remote server response
    private val _todosResponse = MutableStateFlow<TodosRetrofitModel?>(null)
    val todos: StateFlow<TodosRetrofitModel?> = _todosResponse



    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch{
//            getRemoteTodos()
            getNotes()
        }
    }

    // As this insertNote Method is private
    // To call this method we have to create another method
    private suspend fun insertNote(notesModel: NotesModel) {
        roomNotesServicesImplementation.insertNote(notesModel)
    }

    // Example of another function that calls insertNote
    suspend fun saveNote(title: String, description: String) {
        val note = NotesModel(0,title,  description)
        insertNote(note)
    }

    private suspend fun getNotes()  {
        roomNotesServicesImplementation.getAllNotes().collect{response  ->
            _notes.emit(response)
        }

    }

    /*
        suspend fun getNotesReturn() : List<NotesModel> {
            var response =  roomNotesServices.getAllNotes()
            Log.d("TAG", "loadResponse: $response ")
        }
    */




    // * Retrofit Call Start Here *


    private suspend fun getRemoteTodos(){
        try {
            val res = retrofitServiceImplementation.getNotes()
            _todosResponse.emit(res)
        }catch (e:Exception){
            Log.e("Exception","This is ex : ${e.message}")
        }
    }

    suspend fun insertTodo(retTodo:RetTodo){
        var res =  insertRemoteTodo(retTodo)
        Log.d("TAG", "insertRemoteTodo: $res")

    }
    private suspend fun insertRemoteTodo(retTodo:RetTodo): Todo?{
        try {
            var res = retrofitServiceImplementation.insertTodoNotes(retTodo = retTodo)

            Log.d("TAG", "insertRemoteTodo: $res")
            return res
        }catch (e:Exception){
            Log.d("Exception", "This is Response EX: $e")
            return null
        }

    }



}