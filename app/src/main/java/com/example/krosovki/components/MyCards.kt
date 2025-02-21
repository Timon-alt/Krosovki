package com.example.krosovki.components

import android.util.Log
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.krosovki.R
import com.example.krosovki.controllers.FavItemsViewModel
import com.example.krosovki.database.FavItems
import com.example.krosovki.screens.MyIconShape

@Composable
fun NotificationCard() {
    Card(
        colors = CardColors(
            containerColor = Color(0xFFF7F7F9),
            disabledContainerColor = Color.Transparent,
            contentColor = Color.Gray,
            disabledContentColor = Color.Transparent
        ),
        modifier = Modifier
            .width(335.dp)
            .height(128.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Заголовок",
                color = Color.Black,
                fontSize = 16.sp)
            Text(
                text = stringResource(R.string.exmp_text),
                color = Color.Black,
                fontSize = 12.sp)
            Text(
                text = "27.01.2024, 15:42",
                fontSize = 12.sp)
        }
    }
}

@Composable
fun SneakersCard(id: Int, name: String, price: Double, image: String) {
    var clicked by remember { mutableStateOf(false) }
    var icon = if (clicked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
    var iconColor = if (clicked) Color(0xFFF87265) else Color.Black
    val favItemsViewModel: FavItemsViewModel = viewModel()
    val favItemsList = favItemsViewModel.favItems

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(160.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
        ) {
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
                        if (clicked) {
                            favItemsViewModel.addItem(FavItems(id, name, price, image))
                            Log.d("LikeBut", "Товар добавлен в избранное")
                        } else {
                            favItemsViewModel.deleteItem(FavItems(id, name, price, image))
                            Log.d("LikeBut", "Товар удалён из избранного")
                        }


                    }) {
                    Icon(
                        icon, "Like",
                        tint = iconColor
                    )
                }
                AsyncImage(
                    model = image,
                    contentDescription = "Krosovok",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(70.dp)
                )
                Text(
                    text = "BEST SELLER",
                    color = Color(0xFF48B2E7),
                    fontSize = 12.sp
                )
                Spacer(Modifier.size(8.dp))

                Text(
                    text = name,
                    color = Color(0xFF6A6A6A),
                    fontSize = 16.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = " ₽ $price",
                    modifier = Modifier.padding(9.dp)
                )
                MyIconShape()
            }
        }
    }

}

@Composable
fun SneakersCardTrue(id: Int, name: String, price: Double, image: String) {

    val favItemsViewModel: FavItemsViewModel = viewModel()
    val isLiked = favItemsViewModel.favItems.any { it.id == id }
    var clicked by remember { mutableStateOf(isLiked) }

    LaunchedEffect(clicked) {
        if (clicked) {
            favItemsViewModel.addItem(FavItems(id, name, price, image))
        } else {
            favItemsViewModel.deleteItem(FavItems(id, name, price, image))
        }
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(160.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
        ) {
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
                        if (clicked) {
                            favItemsViewModel.addItem(FavItems(id, name, price, image))
                            Log.d("LikeCard", "Товар добавлен в избранное")
                        } else {
                            favItemsViewModel.deleteItem(FavItems(id, name, price, image))
                            Log.d("Like", "Товар удалён из избранного")
                        }


                    }) {
                    Icon(
                        if (clicked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        "Like",
                        tint = if (clicked) Color(0xFFF87265) else Color.Black
                    )
                }
                AsyncImage(
                    model = image,
                    contentDescription = "Krosovok",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(70.dp)
                )
                Text(
                    text = "BEST SELLER",
                    color = Color(0xFF48B2E7),
                    fontSize = 12.sp
                )
                Spacer(Modifier.size(8.dp))

                Text(
                    text = name,
                    color = Color(0xFF6A6A6A),
                    fontSize = 16.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = " ₽ $price",
                    modifier = Modifier.padding(9.dp)
                )
                MyIconShape()
            }
        }
    }

}

@Composable
fun CartCard(id: Int, name: String, price: Double, image: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardColors(
            contentColor = Color.Black,
            disabledContentColor = Color.Transparent,
            containerColor = Color.White,
            disabledContainerColor = Color.Transparent
        ),
        modifier = Modifier
            .width(267.dp)
            .height(104.dp)


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.card_krosovok),
                contentDescription = "sneakers",
                modifier = Modifier
                    .size(85.dp)
                    .background(
                        color = colorResource(R.color.light_gray),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            Column {
                Text(
                    text = "Nike Club Max",
                    fontSize = 16.sp
                )

                Spacer(Modifier.size(6.dp))

                Text(
                    text = "₽584.95",
                    fontSize = 14.sp
                )
            }
        }
    }
}


@Composable
fun CheckoutCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardColors(
            contentColor = Color.Black,
            disabledContentColor = Color.Transparent,
            containerColor = Color.White,
            disabledContainerColor = Color.Transparent
        ),
        modifier = Modifier
            .width(335.dp)
            .height(425.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Контактная информация",
                fontSize = 14.sp
            )

            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(40.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "",
                        modifier = Modifier
                            .background(
                                color = colorResource(R.color.light_gray),
                                shape = RoundedCornerShape(12.dp))
                            .size(40.dp)
                    )

                    Spacer(Modifier.size(12.dp))

                    Column {
                        Text(
                            text = "emmanuel@gmail.com",
                            fontSize = 14.sp
                        )

                        Spacer(Modifier.size(4.dp))

                        Text(
                            text = "Email",
                            fontSize = 12.sp,
                            color = colorResource(R.color.hint)
                        )
                    }

                    Spacer(Modifier.size(72.dp))

                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "",
                        tint = colorResource(R.color.hint),
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(40.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = "",
                        modifier = Modifier
                            .background(
                                color = colorResource(R.color.light_gray),
                                shape = RoundedCornerShape(12.dp))
                            .size(40.dp)
                    )

                    Spacer(Modifier.size(12.dp))

                    Column {
                        Text(
                            text = "emmanuel@gmail.com",
                            fontSize = 14.sp
                        )

                        Spacer(Modifier.size(4.dp))

                        Text(
                            text = "Email",
                            fontSize = 12.sp,
                            color = colorResource(R.color.hint)
                        )
                    }

                    Spacer(Modifier.size(72.dp))

                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "",
                        tint = colorResource(R.color.hint),
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
            Text(text = "Ардес")
            Row(
                horizontalArrangement = Arrangement.spacedBy(125.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "1082 Аэропорт, Нигерии",
                    fontSize = 12.sp,
                    color = colorResource(R.color.hint)
                )
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "",
                    tint = colorResource(R.color.hint),
                    modifier = Modifier.size(15.dp)
                )
            }
            Text(
                text = "Способ оплаты"
            )
        }
    }
}

@Composable
fun CongratulationCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardColors(
            contentColor = Color.Black,
            disabledContentColor = Color.Transparent,
            containerColor = Color.White,
            disabledContainerColor = Color.Transparent
        ),
        modifier = Modifier.width(335.dp).height(400.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(134.dp)
                    .background(
                        color = colorResource(R.color.white_blue),
                        shape = CircleShape)
            ) {
                Image(
                    painter = painterResource(R.drawable.congrat),
                    contentDescription = "",

                    modifier = Modifier
                        .size(86.dp)

                )
            }

            Spacer(Modifier.size(24.dp))

            Text(
                text = "Вы успешно оформили заказ",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(150.dp)
            )

            Spacer(Modifier.size(30.dp))
            Button(
                onClick = {},
                modifier = Modifier.width(237.dp).height(48.dp)
            ) {
                Text(text = "Вернуться к покупкам")
            }

        }
    }
}

@Composable
fun PriceCard(price: Double) {
    val priced by remember { mutableStateOf(price) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardColors(
            contentColor = Color.Black,
            disabledContentColor = Color.Transparent,
            containerColor = Color.White,
            disabledContainerColor = Color.Transparent
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Сумма",
                    fontSize = 16.sp,
                    color = colorResource(R.color.sub_text_dark)
                )
                Text(
                    text = "₽$price",
                    fontSize = 16.sp
                )
            }

            Spacer(Modifier.size(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Доставка",
                    fontSize = 16.sp,
                    color = colorResource(R.color.sub_text_dark)
                )
                Text(
                    text = "₽60.20",
                    fontSize = 16.sp
                )
            }

            Spacer(Modifier.size(18.dp))

            Canvas(modifier = Modifier.fillMaxWidth()) {
                drawLine(
                    start = Offset(x= 0f, y= 0f),
                    end = Offset(x = size.width, y = 0f),
                    color = Color.Gray,
                    strokeWidth = 8.0f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 0f, 10f, 10f), phase = 0f)
                )
            }

            Spacer(Modifier.size(18.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Итого",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "₽${priced + 60.20}",
                    fontSize = 16.sp
                )
            }

            Spacer(Modifier.size(32.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.width(335.dp).height(50.dp)
            ) {
                Text(text = "Оформить Заказ")
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    CongratulationCard()
}