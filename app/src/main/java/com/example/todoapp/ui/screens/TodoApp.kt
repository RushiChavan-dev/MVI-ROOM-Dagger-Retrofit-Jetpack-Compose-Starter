package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todoapp.ui.components.FloatingActionBtn
import com.example.todoapp.ui.components.TopBar
import com.example.todoapp.ui.components.VerticalLazyList
import com.example.todoapp.ui.view.TodoViewModel


@Composable
fun TodoApp(
    navController: NavController,
    viewModel: TodoViewModel = hiltViewModel()
) {
    val notes by viewModel.notes.collectAsState()

    Scaffold(topBar = {
        TopBar(title = "Todo")
    },
        floatingActionButton = { FloatingActionBtn(navController) }) { innerPadding ->
        VerticalLazyList(
            items = notes,
            modifier = Modifier.padding(innerPadding)
        )

//        println(notes)
    }

}


@Preview(showSystemUi = true)
@Composable
fun ShowTodoApp() {
//    TodoApp()
}
