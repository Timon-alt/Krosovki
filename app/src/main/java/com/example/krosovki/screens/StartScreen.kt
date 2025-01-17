package com.example.krosovki.screens

import SegmentedProgressBar
import StartScreenText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

@Composable
fun StartScreen(){
    var currentProgress by remember { mutableStateOf(1) }
    var isVisible by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }
    var buttonText by remember { mutableStateOf("Начать") }
    val listOfImage = listOf(
        R.drawable.noga_one,
        R.drawable.noga_two,
        R.drawable.noga_three)

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
            if(!isVisible){
                Text(text = "ДОБРО ПОЖАЛОВАТЬ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.width(267.dp))
            }
            Image(
                painter = painterResource(listOfImage[counter]),
                contentDescription = "Che za tyagi"
            )
            SegmentedProgressBar(3, currentProgress)
            Spacer(modifier = Modifier.size(30.dp))
            StartScreenText(isVisible, counter)
            Button(onClick = {
                currentProgress++
                isVisible = true
                if(counter != 2) counter++
                buttonText = "Далее"
            },
                shape = RoundedCornerShape(10.dp) ,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(335.dp)
                    .height(50.dp)) {
                Text(text = buttonText, color = Color.Black)

            }
        }
    }
}

@Preview
@Composable
fun PrewviewStartScreen(){
    StartScreen()
}