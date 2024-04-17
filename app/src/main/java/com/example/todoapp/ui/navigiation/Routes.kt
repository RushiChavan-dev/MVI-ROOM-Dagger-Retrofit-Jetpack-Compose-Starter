package com.example.todoapp.ui.navigiation

sealed class Routes(val route: String) {
    object FirstScreen : Routes("firstScreen")

}