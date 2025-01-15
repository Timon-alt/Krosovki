package com.example.krosovki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krosovki.ui.theme.KrosovkiTheme
import com.example.krosovki.ui.theme.fontFamily

// https://www.figma.com/design/YFIQ0o0c2VozfcVD5PQAxN/Matule-with-Style-guide-ORIG-(Main)?node-id=8103-748&t=25NIK4P5pw25X0jl-0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KrosovkiTheme { Greeting() }
        }
    }
}

@Composable
fun Greeting() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if(passwordVisibility)
        Icons.Filled.Visibility
    else
        Icons.Filled.VisibilityOff

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Привет!")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Заполните Свои Данные Или")
            Text(text = "Продолжите Через Социальные Медиа")
            Spacer(modifier = Modifier.size(35.dp))
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

            Spacer(modifier = Modifier.size(26.dp))
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
                        visualTransformation = if(passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation(),

                        modifier = Modifier
                            .width(335.dp)
                            .height(48.dp)
                    )
                    TextButton(onClick = {
                        //Код
                    },
                        modifier = Modifier.align(Alignment.End)) {
                        Text(text = "Востановить")
                    }
                }
            }
            Button(onClick = {
                //Код
            },
                modifier = Modifier
                    .width(335.dp)
                    .height(50.dp)){
                Text(text = "Войти")
            }
            Spacer(modifier = Modifier.size(100.dp))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Вы впервые?")
                Text(text = "Создать пользователя")
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KrosovkiTheme {
        Greeting()
    }
}