package com.example.krosovki.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.krosovki.database.FilterTextViewModel


@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {
        Column(Modifier.padding(20.dp)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(110.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                FilledTonalButton(
                    onClick = { },
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(44.dp),
                    colors = ButtonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray
                    )
                ) {
                    Icon(Icons.Filled.ArrowBackIosNew, "Back")
                }

                Text(
                    text = "Поиск",
                    fontSize = 16.sp
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen(){
    MySearchBar()
}


@Composable
fun MySearchBar(modifier: Modifier = Modifier, viewModel: FilterTextViewModel = viewModel()) {
    val filteredItems by viewModel.filteredItems.collectAsStateWithLifecycle()
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(all = 20.dp)
            .background(Color(0xFFF7F7F9))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(110.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            FilledTonalButton(
                onClick = { },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(44.dp),
                colors = ButtonColors(
                    containerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray
                )
            ) {
                Icon(Icons.Filled.ArrowBackIosNew, "Back")
            }

            Text(
                text = "Поиск",
                fontSize = 16.sp
            )
        }

        Spacer(Modifier.size(26.dp))

        TextField(
            value = text,
            onValueChange = {
                text = it
                viewModel.filterText(text)
            },
            leadingIcon = {Icon(Icons.Filled.Search, "Search")},
            trailingIcon = {Icon(Icons.Filled.Mic, "Mic")},
            placeholder = { Text("Поиск") },
            modifier = Modifier
                .fillMaxWidth()
                

        )

        LazyColumn {
            items(
                count = filteredItems.size,
                key = { index -> filteredItems[index]}
            ) {
                ListItem(
                    headlineContent = { Text(filteredItems[it]) },
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(10.dp)
                )
            }
        }
    }

}