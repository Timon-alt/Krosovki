package com.example.krosovki.screens

import RadioButtonSingleSelection
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krosovki.R

@Composable
fun LogInScreen(onClick: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(false) }
    var hiText by remember { mutableStateOf("Привет!") }
    var btnText by remember { mutableStateOf("Войти") }
    var btnText2 by remember { mutableStateOf("Вы впервые?Создать пользователя") }

    val icon = if (passwordVisibility)
        Icons.Filled.Visibility
    else
        Icons.Filled.VisibilityOff

    Row(horizontalArrangement = Arrangement.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = hiText)

            Text(
                text = "Заполните Свои Данные Или Продолжите Через Социальные Медиа",
                textAlign = TextAlign.Center,
                modifier = Modifier.width(315.dp).height(48.dp))
            if(isVisible){
                Column {
                    Text(text = "Ваше имя")
                    Spacer(modifier = Modifier.size(12.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(335.dp)
                            .height(48.dp)
                    )
                }
            }
            Column {
                Text(text = "Email")
                Spacer(modifier = Modifier.size(12.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp)
                )
            }
            Box {
                Column() {
                    Text(text = "Пароль")
                    Spacer(modifier = Modifier.size(12.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(icon, "Visibility")
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        shape = RoundedCornerShape(10.dp),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation(),

                        modifier = Modifier
                            .width(335.dp)
                            .height(48.dp)
                    )
                    if(!isVisible){
                        TextButton(
                            onClick = {
                                //Код
                                //Изменение
                            },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = "Востановить")
                        }
                    }
                }
            }
            if(isVisible){
                RadioButtonSingleSelection()
            }

            Button(
                onClick = {
                    //Код
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(335.dp)
                    .height(50.dp)
            ) {
                Text(text = btnText)
            }
            TextButton(onClick = {
                if(!isVisible){
                    isVisible = true
                    btnText = "Регистрация"
                    btnText2 = "Есть аккаунт?Войти"
                    hiText = "Регистрация"
                }
                else{
                    isVisible = false
                    btnText = "Войти"
                    btnText2 = "Вы впервые?Создать пользователя"
                    hiText = "Привет!"
                }
            }) {
                Text(text = btnText2)
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen(){
    LogInScreen {  }
}