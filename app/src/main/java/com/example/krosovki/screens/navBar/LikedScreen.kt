package com.example.krosovki.screens.navBar

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LikedScreen(){
    Box(contentAlignment = Alignment.Center) {
        Text(text = "LikedScreen")
    }
}

@Preview
@Composable
fun PreviewLikedScreen(){
    LikedScreen()
}