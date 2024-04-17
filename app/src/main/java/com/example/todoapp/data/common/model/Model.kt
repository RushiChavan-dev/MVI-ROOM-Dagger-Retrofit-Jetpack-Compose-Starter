package com.example.todoapp.data.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String = ""
)


