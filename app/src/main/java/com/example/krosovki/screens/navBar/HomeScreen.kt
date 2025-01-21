package com.example.krosovki.screens.navBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    var search by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(Icons.Filled.Menu, "Menu",
                modifier = Modifier.size(37.dp))
            Text(text = "Главная", fontSize = 32.sp)
            Icon(Icons.Filled.ShoppingCart, "Cart",
                modifier = Modifier.size(37.dp))
        }
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()){
            OutlinedTextField(
                value = search,
                onValueChange = {search = it},
                placeholder = { Text(text = "Поиск") },
                leadingIcon = {
                    IconButton(onClick = {/*TODO*/}) {
                        Icon(Icons.Filled.Search, "Search")
                    }
                },
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.width(269.dp).height(52.dp)
            )
            Spacer(Modifier.size(14.dp))
            Button(
                onClick = {},
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(52.dp)
            ) {
                Icon(Icons.Filled.FilterList, "Filter")
            }

        }
        Text(text = "Категории")
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.width(108.dp).height(40.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = "Все")
                }
            }
            Card(
                modifier = Modifier.width(108.dp).height(40.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = "Outdoor")
                }
            }
            Card(
                modifier = Modifier.width(108.dp).height(40.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = "Tennis")
                }
            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Популярное")
            Text(
                text = "Все",
                fontSize = 12.sp,
                color = Color(0xFF48B2E7),
                modifier = Modifier.clickable {  })
        }

    }
}

@Preview
@Composable
fun PreviewHomewScreen(){
    HomeScreen()
}