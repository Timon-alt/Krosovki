package com.example.krosovki.screens

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.Icon
import android.view.textclassifier.ConversationActions.Request
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.krosovki.R
import com.example.krosovki.components.OtpInputTextField

@Composable
fun EnterWithoutPass(onClick: () -> Unit){
    var email by remember { mutableStateOf("") }
    val visible = remember { mutableStateOf(false) }
    val openMyDialog = remember { mutableStateOf(false) }
    val mainText = if(!visible.value) R.string.fgt_pass_mainText1 else R.string.fgt_pass_mainText2
    val minorText = if(!visible.value) R.string.fgt_pass_anotherText1 else R.string.fgt_pass_anotherText2

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(
                    onClick = {/*TODO*/},
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(44.dp)
                ) {
                    Icon(Icons.Filled.ArrowBackIosNew, "Back")
                }
            }
            Text(
                text = stringResource(mainText),
                fontSize = 32.sp)

            Text(text =  stringResource(minorText),
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                modifier = Modifier.width(335.dp)
            )
            if (!visible.value) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp)
                )
                Button(
                    onClick = {
                        openMyDialog.value = !openMyDialog.value
                        visible.value = !visible.value
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(335.dp)) {
                    Text(text = "Отправить")
                }
            }
            else {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "OTP Код"
                    )
                }

                OtpInputTextField(6)

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Отправить заново"
                    )
                    // Сделать таймер
                    Text(
                        text = "00:30"
                    )
                }
            }
        }
    }
    when {
        openMyDialog.value -> {
            MyDialog(
                onDismissRequest = {openMyDialog.value = false},
            )
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

@Composable
fun MyDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        CardMessage()
    }
}
