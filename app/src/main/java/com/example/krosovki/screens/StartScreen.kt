package com.example.krosovki.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

@Composable
fun StartScreen(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF48B2E7), Color(0xFF44A9DC), Color(0xFF2B6B8B))
                )
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "ДОБРО",
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                color = Color.White)
            Text(text = "ПОЖАЛОВАТЬ",
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                color = Color.White)
            Image(
                painter = painterResource(R.drawable.noga_one),
                contentDescription = "Che za tyagi"
            )
            // Подумац как повернуть пикчу
            Button(onClick = {/*TODO*/},
                shape = RoundedCornerShape(10.dp) ,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(335.dp)
                    .height(50.dp)) {
                Text(text = "Начать", color = Color.Black)

            }
        }
    }


}

@Preview
@Composable
fun PrewviewStartScreen(){
    StartScreen()
}