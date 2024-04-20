package com.example.todoapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todoapp.data.common.model.RetTodo
import com.example.todoapp.ui.view.TodoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TodoCreateNote(
    navController: NavHostController, viewModel: TodoViewModel = hiltViewModel()
) {
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val context = LocalContext.current // Get the context from LocalContext

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Description field wrapped in a Box with dynamic height
        Box(
            modifier = Modifier
                .weight(1f) // Takes up remaining space
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Save button aligned to end
        Button(
            onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    showError = false
                    CoroutineScope(Dispatchers.IO).launch{
                        viewModel.saveNote(title,description)

                    }
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.insertTodo(RetTodo(todo = title, completed = true, userId = 7))
                    }
                } else {
                    showError = true
                }

                if (showError) {
                    Toast.makeText(
                        context, "Title and Description cannot be empty", Toast.LENGTH_SHORT
                    ).show()
                }else{
                    navController.popBackStack()
                }


            }, modifier = Modifier
                .align(Alignment.End)
                .fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

