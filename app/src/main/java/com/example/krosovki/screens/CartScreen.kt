package com.example.krosovki.screens

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R
import com.example.krosovki.components.CheckoutCard

//человек яйца <3

@Composable
fun CartScreen(){
Surface(
    modifier = Modifier.fillMaxSize(),
    color = colorResource(R.color.light_gray)
) {
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(100.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            FilledTonalButton(
                onClick = {  },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(44.dp),
                colors = ButtonColors(
                    containerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray
                )
            ) {
                Icon(Icons.Filled.ArrowBackIosNew, "Back")
            }
            Text(
                text = "Корзина",
                fontSize = 16.sp
            )
        }

        Spacer(Modifier.size(46.dp))

        CheckoutCard()

        Spacer(Modifier.size(26.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Сумма",
                color = colorResource(R.color.hint)
            )

            Text(
                text = "₽753.95"
            )
        }

        Spacer(Modifier.size(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Доставка",
                color = colorResource(R.color.hint)
            )
            Text(
                text = "₽60.20"
            )
        }

        Spacer(Modifier.size(24.dp))

        Canvas(modifier = Modifier.fillMaxWidth()) {
            drawLine(
                start = Offset(x= 0f, y= 0f),
                end = Offset(x = size.width, y = 0f),
                color = Color.Gray,
                strokeWidth = 8.0f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 0f, 10f, 10f), phase = 0f)
            )
        }

        Spacer(Modifier.size(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Итого",
                fontSize = 16.sp
            )
            Text(
                text = "₽814.15",
                fontSize = 16.sp,
                color = colorResource(R.color.Accent)
            )

        }

        Spacer(Modifier.size(24.dp))

        Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text(
                text = "Подтвердить"
            )
        }
    }
}

}

@Preview
@Composable
fun PreviewCartScreen(){
    CartScreen()
}