package com.example.krosovki.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtpInputTextField(num: Int) {
    var otpText by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= num) {
                otpText = it
            }
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(num) { index ->
                val number = when {
                    index >= otpText.length -> ""
                    else -> otpText[index]
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(80.dp)
                        .width(40.dp)
                        .background(
                            Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Text(
                        text = number.toString(),
                        style = MaterialTheme.typography.titleLarge
                    )


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOtpScreen() {
    OtpInputTextField(6)
}