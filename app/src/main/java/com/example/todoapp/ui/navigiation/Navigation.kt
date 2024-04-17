package com.example.todoapp.ui.navigiation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.screens.TodoApp


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.FirstScreen.route) {


        composable(route = Routes.FirstScreen.route) {
            TodoApp(navController = navController) {

            }
        }


    }
}