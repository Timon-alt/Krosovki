package com.example.krosovki.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

val sneakersList = listOf(
    R.drawable.card_krosovok_two,
    R.drawable.card_krosovok_three,
    R.drawable.card_krosovok_four,
    R.drawable.card_krosovok_five,
)

@Composable
fun DetailsScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(13.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                FilledTonalButton(
                    onClick = {  },
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
                    text = "Sneaker Shop",
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
                    Icon(Icons.Outlined.ShoppingBag, "Like")
                }
            }

            Text(
                text = "Nike Air Max 270 Essential",
                fontSize = 26.sp,
                color = Color.Black,
                modifier = Modifier.width(254.dp)
            )
            Text(
                text = "Men's Shoes",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                text = "₽179.39",
                fontSize = 24.sp,
            )
        }
        Image(
            painter = painterResource(R.drawable.card_krosovok),
            contentDescription = "Krosovok",
            modifier = Modifier.size(240.dp)
        )
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(count = sneakersList.size) { sneaker ->
                    SneakerCard(sneakersList[sneaker])
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Вставка Max Air 270 Обеспечивает Непревзойдённый Комфорт В Течение Всего" +
                            "Дня. Изящный Дизайн.....",
                    color = Color.Gray,
                    modifier = Modifier.width(335.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Подробнее",
                        color = Color(0xFF48B2E7)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
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
                    onClick = {/*TODO*/}) {
                    Icon(Icons.Outlined.FavoriteBorder, "Like")
                }
                Button(
                    onClick = {/*TODO*/},
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(52.dp)
                ) {
                    Text(text = "В Корзину",
                        color = Color.White)
                }

            }

        }
    }
}

@Preview
@Composable
fun PreviewDetailsScreen() {
    DetailsScreen()
}

@Composable
fun SneakerCard(sneakerImage: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.size(56.dp)
    ) {
        Image(
            painter = painterResource(sneakerImage),
            contentDescription = "Sneaker"
        )
    }

}