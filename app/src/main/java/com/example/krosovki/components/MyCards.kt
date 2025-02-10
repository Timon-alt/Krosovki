package com.example.krosovki.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.krosovki.R
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
fun SneakersCard(name: String, price: Float, image: String) {
    var clicked by remember { mutableStateOf(false) }
    var icon = if (clicked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
    var iconColor = if (clicked) Color(0xFFF87265) else Color.Black

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

@Preview
@Composable
fun PreviewCard() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent
        )

    )
}