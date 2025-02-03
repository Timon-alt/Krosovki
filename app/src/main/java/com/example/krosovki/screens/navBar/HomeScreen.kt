package com.example.krosovki.screens.navBar

import CardCheeeck
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

@Composable
fun HomeScreen(onClick: () -> Unit){
    var search by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ){
            Icon(Icons.Filled.Menu, "Menu",
                modifier = Modifier.size(37.dp))
            Text(text = "Главная", fontSize = 32.sp)
            FilledTonalButton(
                onClick = {},
                colors = ButtonColors(
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black,
                    containerColor = Color.White,
                    disabledContainerColor = Color.Gray),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(44.dp)) {
                Icon(Icons.Outlined.ShoppingBag, "ShopBag")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(20.dp)){
            TextField(
                value = search,
                onValueChange = {search = it},
                placeholder = { Text(text = "Поиск") },
                leadingIcon = {
                    IconButton(onClick = {/*TODO*/}) {
                        Icon(Icons.Filled.Search, "Search")
                    }
                },
                shape = RoundedCornerShape(14.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedLabelColor = Color.Red
                ),
                modifier = Modifier.width(269.dp).height(52.dp)
            )
            Spacer(Modifier.size(14.dp))
            FilledTonalButton(
                onClick = {},
                shape = CircleShape,
                colors = ButtonColors(
                    containerColor = Color(0xFF48B2E7),
                    disabledContainerColor = Color.Gray,
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(52.dp)
            ) {
                Icon(Icons.Outlined.FilterList, "Filter",
                    tint = Color.White)
            }

        }
        Column(Modifier.padding(20.dp)) {
            Text(text = "Категории")
            Spacer(Modifier.size(19.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier.width(108.dp).height(40.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().background(Color.White)) {
                        Text(text = "Все")
                    }
                }
                Card(
                    modifier = Modifier.width(108.dp).height(40.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().background(Color.White)) {
                        Text(text = "Outdoor")
                    }
                }
                Card(
                    modifier = Modifier.width(108.dp).height(40.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().background(Color.White)) {
                        Text(text = "Tennis")
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            Text(text = "Популярное")
            Text(
                text = "Все",
                fontSize = 12.sp,
                color = Color(0xFF48B2E7),
                modifier = Modifier.clickable { onClick() })
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            CardCheeeck()
            CardCheeeck()
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            Text(text = "Акции")
            Text(
                text = "Все",
                fontSize = 12.sp,
                color = Color(0xFF48B2E7),
                modifier = Modifier.clickable {  })
        }
        Image(
            painter = painterResource(R.drawable.reclama),
            contentDescription = "banner",
            modifier = Modifier.width(335.dp).height(95.dp))
    }
}

@Preview
@Composable
fun PreviewHomewScreen(){
    HomeScreen({})
}