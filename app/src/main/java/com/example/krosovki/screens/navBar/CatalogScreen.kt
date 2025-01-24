package com.example.krosovki.screens.navBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CatalogScreen(){
    val clicked by remember { mutableStateOf(false) }
    val txtColor = if(clicked) Color.Green else Color.Red
    Box(contentAlignment = Alignment.Center) {
        Text(text = "CatalogScreen",
            color = txtColor,
            modifier = Modifier.clickable { clicked != clicked })
    }
}

@Preview
@Composable
fun PreviewCatalogScreen(){
    CatalogScreen()
}