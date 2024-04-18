package com.example.todoapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.data.repository.room.NotesDaoService
import kotlinx.coroutines.flow.Flow

@Composable
fun VerticalLazyList(modifier: Modifier = Modifier) {
    // Create a list of items
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    // Create a LazyColumn
    LazyColumn(modifier = modifier) {
        // Add items to the LazyColumn
        items(items) { item ->
            // Create a composable for each item
            Text(text = item)
        }
    }
}