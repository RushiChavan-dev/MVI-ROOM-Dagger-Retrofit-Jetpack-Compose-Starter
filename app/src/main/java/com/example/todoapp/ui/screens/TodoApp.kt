package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.todoapp.ui.components.FloatingActionBtn
import com.example.todoapp.ui.components.TopBar
import com.example.todoapp.ui.components.VerticalLazyList


@Composable
fun TodoApp(
    navController: NavController,
    onNavigate: () -> Unit
) {
    Scaffold(topBar = {
        TopBar(title = "Todo")
    },
        floatingActionButton = { FloatingActionBtn() }) { innerPadding ->
        VerticalLazyList(modifier = Modifier.padding(innerPadding))
    }

}


@Preview(showSystemUi = true)
@Composable
fun ShowTodoApp() {
//    TodoApp()
}
