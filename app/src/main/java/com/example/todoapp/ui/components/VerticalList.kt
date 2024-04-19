package com.example.todoapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.data.common.model.NotesModel

@Composable
fun VerticalLazyList(modifier: Modifier = Modifier, items: List<NotesModel>) {
    // Create a list of items
//    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    // Create a LazyColumn
    LazyColumn(modifier = modifier) {
        // Add items to the LazyColumn
        items(items) { item ->
            // Create a composable for each item
            ItemBox(item.title)

        }
    }
}

@Composable
fun ItemBox(title: String) {
    Card(
        shape = RoundedCornerShape(16.dp), // Set the corner radius
        modifier = Modifier.padding(8.dp).fillMaxWidth(),

        // Add padding around the card
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic

            // Add padding inside the card
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun testList(){
    Column {

        VerticalLazyList(items = listOf(NotesModel(1, "My Surname", "3")))
        // Add previews of other composables if needed
    }

}