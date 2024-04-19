package com.example.todoapp.ui.navigiation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.screens.TodoApp
import com.example.todoapp.ui.screens.TodoCreateNote


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.FirstScreen.route)

    {

        composable(route = Routes.FirstScreen.route) {
            TodoApp(navController = navController)
        }

        composable(route = Routes.TodoCreateNoteScreen.route) {
            TodoCreateNote(navController = navController)
        }



    }
}