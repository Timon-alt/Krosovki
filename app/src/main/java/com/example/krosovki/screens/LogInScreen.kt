package com.example.krosovki.screens

import RadioButtonSingleSelection
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.krosovki.R
import com.example.krosovki.controllers.LogInController

@Composable
fun LoginScreen(onClick: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(false) }
    var hiText by remember { mutableStateOf("Привет!") }
    var btnText by remember { mutableStateOf("Войти") }
    var btnText2 by remember { mutableStateOf("Вы впервые?Создать пользователя") }
    val logInController = LogInController()

    val icon = if (passwordVisibility)
        Icons.Filled.Visibility
    else
        Icons.Filled.VisibilityOff

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Spacer(Modifier.size(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            FilledTonalButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(44.dp),
                colors = ButtonColors(
                    containerColor = Color(0xFFF7F7F9),
                    disabledContainerColor = Color.Gray,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray
                )
            ) {
                Icon(Icons.Filled.ArrowBackIosNew, "Back")
            }
        }

        Spacer(Modifier.size(30.dp))

        Text(
            text = hiText,
            fontSize = 32.sp,
            color = Color.Black)

        Spacer(Modifier.size(8.dp))

        Text(
            text = "Заполните Свои Данные Или Продолжите Через Социальные Медиа",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = colorResource(R.color.sub_text_dark),
            modifier = Modifier.width(315.dp).height(48.dp))

        Spacer(Modifier.size(35.dp))

        if(isVisible){
            Column {
                Text(text = "Ваше имя")
                Spacer(modifier = Modifier.size(12.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(335.dp)

                )
            }
        }
        Column {
            Text(text = "Email")
            Spacer(modifier = Modifier.size(12.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .width(335.dp)
                    .background(
                        color = colorResource(R.color.light_gray),
                        shape = RoundedCornerShape(14.dp)
                    )
            )
        }

        Spacer(Modifier.size(30.dp))

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
                    shape = RoundedCornerShape(14.dp),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(335.dp)
                        .background(
                            color = colorResource(R.color.light_gray),
                            shape = RoundedCornerShape(14.dp)
                        )
                )
                if(!isVisible){
                    TextButton(
                        onClick = {
                            //Код
                            //Изменение
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(
                            text = "Востановить",
                            fontSize = 12.sp,
                            color = colorResource(R.color.sub_text_dark)
                        )
                    }
                }
            }
        }
        if(isVisible){
            RadioButtonSingleSelection()
        }

        Spacer(Modifier.size(24.dp))

        Button(
            onClick = {
                when(btnText) {
                    "Войти" -> {
                        if (logInController.signIn(email, password)) {
                            onClick()
                        } else {
                            // Выдать диалоговое окно к примеру
                        }
                    }
                    "Регистрация" -> {
                        if (logInController.signUp(email, password)) {
                            onClick()
                        } else {
                            // Вызвать диалоговое окно к примеру
                        }
                    }
                }
            },
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .width(335.dp)
                .height(50.dp)
        ) {
            Text(text = btnText)
        }
        AsyncImage(
            model = "https://s3-alpha-sig.figma.com/img/2c70/5924/fd56edd26a4546a27a004864553e05d9?Expires=1739750400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=RLR1OXbofsMTPJTZtWDPZ1voxmE-DYT4lo~I-X~yNqkK7L68pCVhnqIQjZlgYv3Lv0UkfJJP5teM12yh6tZOrVh6r2UfBHOgpAkw8VrrJ7T1PZvz1e2tlvku9-X9dNq3~iCqa6ad25t1q9JtxGuFyvQ~fnWrxJw73vnt5nRfdcI01-LA8fCWmx7ie1LNKfEdiqkpQ1~b7w7~FK4I98Vf2Q~02GinPOPFYoMhKsavxZt8V1ywy2rmHr8hOJTosUJ0fwBiHVmVu9PubXgDB5OOYoXqCixnajB1aveIJ0d-IUhO2~hjku7AH-T8Xnmt51eUc0H2PhnLeAiCZVRFf934xA__",
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(Modifier.size(209.dp))

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
            Text(
                text = btnText2,
                fontSize = 16.sp )
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen {  }
}