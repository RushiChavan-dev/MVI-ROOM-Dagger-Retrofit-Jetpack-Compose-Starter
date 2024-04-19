package com.example.todoapp.domain.repository.localroom

import com.example.todoapp.data.common.model.NotesModel
import com.example.todoapp.data.repository.room.NotesDaoService
import com.example.todoapp.data.repository.room.RoomNotesDaoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


// Room Implementation

/*
* This class is the implementation
* of RoomNotesDaoRepo.
* We are overriding all the methods of
* RoomNotesDaoRepo also as we have used
* Dependency Injection We are calling this
* class into AppModule.
*
* */



class RoomNotesServicesImplementation @Inject constructor(private val notesDaoService: NotesDaoService) : RoomNotesDaoRepo {
    // Implementation
//    val note = NotesModel(
//        id = 2,
//        title = "Note 2",
//        description = "Testing Node."
//    )
    override suspend fun insertNote(notesModel : NotesModel) {
        return notesDaoService.insertNote(notesModel)
    }

    override fun getAllNotes(): Flow<List<NotesModel>> {
        return notesDaoService.getAllNotes()
    }
}
