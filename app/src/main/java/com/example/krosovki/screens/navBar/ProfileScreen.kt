package com.example.krosovki.screens.navBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var adress by remember { mutableStateOf("") }
    var phoneNum by remember { mutableStateOf("") }
    val visible = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            if (visible.value) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        visible.value = !visible.value
                    }) {
                        Text(text = "Сохранить")
                    }
                }
            }
            else {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        Icons.Filled.Menu,
                        "Menu",
                        modifier = Modifier.size(30.dp))
                    Text(
                        text = "Профиль",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp)
                    Icon(
                        Icons.Filled.Edit,
                        "Edit",
                        tint = Color.White,
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                color = Color(0xFF48B2E7),
                                shape = CircleShape
                            )
                            .clickable { visible.value = !visible.value }
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.yaica),
                    contentDescription = "Ava",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .height(96.dp)
                        .fillMaxWidth()
                        .background(
                            shape = CircleShape,
                            color = Color.Transparent
                        )
                )
                Text(
                    text = "Emmanuel Oyiboke"
                )
            }

            Image(
                painter = painterResource(R.drawable.qr_code),
                contentDescription = "qr_code",
                alignment = Alignment.Center,
                modifier = Modifier
                    .width(335.dp)
                    .height(67.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Имя")
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it},
                    readOnly = !visible.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .background(
                            color = colorResource(R.color.light_gray),
                            shape = RoundedCornerShape(14.dp)
                        )
                )

                Text(text = "Фамилия")
                OutlinedTextField(
                    value = surname,
                    onValueChange = { surname = it},
                    readOnly = !visible.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF7F7F9),
                            shape = RoundedCornerShape(14.dp)
                        )
                )

                Text(text = "Адресс")
                OutlinedTextField(
                    value = adress,
                    onValueChange = { adress = it},
                    readOnly = !visible.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF7F7F9),
                            shape = RoundedCornerShape(14.dp)
                        )
                )

                Text(text = "Телефон")
                OutlinedTextField(
                    value = phoneNum,
                    onValueChange = { phoneNum = it},
                    readOnly = !visible.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF7F7F9),
                            shape = RoundedCornerShape(14.dp)
                        )
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen(){
    ProfileScreen()
}