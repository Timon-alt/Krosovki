package com.example.krosovki.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

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