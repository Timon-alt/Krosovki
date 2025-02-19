package com.example.krosovki.screens.navBar

import CardCheeeck
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.R
import com.example.krosovki.components.SneakersCardTrue
import com.example.krosovki.controllers.FavItemsViewModel
import com.example.krosovki.screens.MyIconShape

var counterr = 4

@Composable
fun LikedScreen(navController: NavController){
    var counter by remember { mutableStateOf(counterr) }
    val favItemsViewModel: FavItemsViewModel = viewModel()
    val favItemsList = favItemsViewModel.favItems

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {
        Column(Modifier.padding(20.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                FilledTonalButton(
                    onClick = { navController.popBackStack() },
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
                    text = "Избранное",
                    fontSize = 16.sp
                )
                FilledTonalButton(
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(44.dp),
                    colors = ButtonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray
                    ),
                    onClick = {}) {
                    androidx.compose.material.Icon(Icons.Outlined.Favorite, "Like",
                        tint = Color(0xFFF87265))
                }
            }
            Spacer(Modifier.size(20.dp))
            LazyVerticalGrid(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                columns = GridCells.Fixed(2),
                modifier = Modifier
            ) {
                items(favItemsList) { item ->
                    SneakersCardTrue(item.id, item.name, item.price, item.image_url)
                }
            }
        }
    }
}

@Composable
fun counter(): Int{
    var counter by remember { mutableStateOf(4) }
    return counter
}

@Composable
fun LikedCard(){
    var clicked by remember { mutableStateOf(false) }


    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(160.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier) {
            Column(Modifier.padding(9.dp)) {
                FilledTonalButton(
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),

                    colors = ButtonColors(
                        containerColor = Color(0xFFF7F7F9),
                        disabledContainerColor = Color.Gray,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray
                    ),
                    onClick = {
                        clicked = !clicked
                        if(clicked) counterr--

                    }) {
                    androidx.compose.material.Icon(Icons.Filled.Favorite, "Like",
                        tint = Color(0xFFF87265))
                }
                Image(
                    painter = painterResource(R.drawable.card_krosovok),
                    contentDescription = "Krosovok",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(70.dp)
                )
                androidx.compose.material3.Text(
                    text = "BEST SELLER",
                    color = Color(0xFF48B2E7),
                    fontSize = 12.sp)
                Spacer(Modifier.size(8.dp))

                androidx.compose.material3.Text(
                    text = "Nike Air Max",
                    color = Color(0xFF6A6A6A),
                    fontSize = 16.sp)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                androidx.compose.material3.Text(
                    text = " ₽ 752.00",
                    modifier = Modifier.padding(9.dp))
                MyIconShape()
            }
        }
    }
}

@Preview
@Composable
fun PreviewLikedScreen() {
    LikedScreen(rememberNavController())
}