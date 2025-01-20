package com.example.krosovki.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EnterWithoutPass(onClick: () -> Unit){
    var email by remember { mutableStateOf("") }
    Column {
        Row(horizontalArrangement = Arrangement.Start) {
            OutlinedButton(
                onClick = {/*TODO*/},
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(44.dp)
            ) {
                Icon(Icons.Filled.ArrowBackIosNew, "Back")
            }
        }
        Row(horizontalArrangement = Arrangement.Center){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.height(272.dp).fillMaxWidth()
            ) {

                Text(text = "Забыл пароль",
                    fontSize = 32.sp)
                Text(text =  "Введите Cвою Учётную Запись Для Сброса",
                    textAlign = TextAlign.Center,
                    color = Color.LightGray,
                    modifier = Modifier.width(335.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp)
                )
                Button(
                    onClick = {/*TODO*/},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(335.dp)) {
                    Text(text = "Отправить")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewEnterPass(){
    EnterWithoutPass({})
}
