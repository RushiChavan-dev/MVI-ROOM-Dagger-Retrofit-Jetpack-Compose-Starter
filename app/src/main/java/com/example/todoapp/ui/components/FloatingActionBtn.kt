package com.example.todoapp.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
fun FloatingActionBtn(navController: NavController) {
    FloatingActionButton(
        onClick = {
            navController.navigate("todoCreateNoteScreen")
        },
        shape = CircleShape,
        containerColor = Color.Yellow,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}