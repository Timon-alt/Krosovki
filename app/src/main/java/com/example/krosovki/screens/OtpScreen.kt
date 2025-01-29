package com.example.krosovki.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.rounded.MarkEmailUnread
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EnterWithoutPass(onClick: () -> Unit){
    var email by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(Modifier.padding(20.dp)) {
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
                        onClick = { visible = !visible},
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.width(335.dp)) {
                        Text(text = "Отправить")
                    }

                    AnimatedVisibility(visible) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()) {
                            CardMessage()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEnterPass(){
    EnterWithoutPass {  }
}

@Composable
fun CardMessage() {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(335.dp)
            .height(196.dp)


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            MyMessageIcon()

            Spacer(Modifier.size(24.dp))

            Text(
                text = "Проверьте Ваш Email",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Text(
                text = "Мы Отправили Код Восстановления Пароля На Вашу Электронную Почту.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }

    }

}
