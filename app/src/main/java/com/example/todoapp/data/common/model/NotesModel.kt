package com.example.todoapp.data.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NotesModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String = "",
    val description : String= ""
)


