package com.example.krosovki.screens.navBar

import CardCheeeck
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.krosovki.components.SneakersCard
import com.example.krosovki.controllers.SneakersViewModel

@Composable
fun PopularScreen(navController: NavController,
                  onClick: () -> Unit, viewModel: SneakersViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        // Запускаем загрузку данных при первом отображении
        viewModel.loadSneakers()
    }

    val sneakers by viewModel.snekaersList.collectAsState()

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
                    onClick = {navController.popBackStack()},
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
                    text = "Популярное",
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
                    onClick = {onClick()}) {
                    androidx.compose.material.Icon(Icons.Outlined.FavoriteBorder, "Like")
                }
            }
            Spacer(Modifier.size(20.dp))
            LazyVerticalGrid(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                columns = GridCells.Fixed(2),
                modifier = Modifier
            ) {
                //,items(sneakers){ sneaker ->
                //,    SneakersCard(sneaker.name) htrh
                //,}
            }
        }

    }
}

@Preview
@Composable
fun PreviewPopularScreen(){

}