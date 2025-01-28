import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R
import com.example.krosovki.screens.MyIconShape

// В этом файле происходят разного рода тесты

@Composable
fun SegmentedProgressBar(
    segments: Int,
    progress: Int,
    modifier: Modifier = Modifier,
    completedColor: Color = Color.White,
    incompleteColor: Color = Color.Gray,
    width: Dp = 123.dp,
    height: Dp = 5.dp,
    segmentCornerSize: Dp = 12.dp,
    firstLastSegmentCornerSize: Dp = 12.dp,
    spaceBetweenSegments: Dp = 4.dp,
) {
    require(segments >= 2) { "segments must be equal to or greater than 2" }
    require(progress in 0..segments) { "progress must be less than or equal to segments" }

    Row(
        modifier = modifier.height(height).width(width),
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenSegments),
    ) {
        for (index in 0 until segments) {
            val shape = when (index) {
                0 -> RoundedCornerShape(
                    topStart = firstLastSegmentCornerSize,
                    topEnd = segmentCornerSize,
                    bottomStart = firstLastSegmentCornerSize,
                    bottomEnd = segmentCornerSize,
                )

                segments - 1 -> RoundedCornerShape(
                    topStart = segmentCornerSize,
                    topEnd = firstLastSegmentCornerSize,
                    bottomStart = segmentCornerSize,
                    bottomEnd = firstLastSegmentCornerSize,
                )

                else -> RoundedCornerShape(segmentCornerSize)
            }

            val color = if (index < progress) completedColor else incompleteColor

            Box(
                modifier = Modifier
                    .clip(shape)
                    .background(color)
                    .fillMaxHeight()
                    .weight(1f),
            )
        }
    }
}

@Composable
fun StartScreenText(isVisible: Boolean, counter: Int){
    val listOfText1 = arrayListOf(
        R.string.start_screen1,
        R.string.start_screen1,
        R.string.start_screen3,)
    val listOfText2 = arrayListOf(
        R.string.start_screen2,
        R.string.start_screen2,
        R.string.start_screen4
    )
    if(isVisible){
        Column {
            Text(
                text = stringResource(listOfText1[counter]),
                color = Color.White,
                fontSize = 34.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(315.dp))
            Text(
                text = stringResource(listOfText2[counter]),
                color = Color.LightGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(315.dp))
        }
    }
    }

@Composable
fun esh(){
    Row {
        Text("Вы впервые?")
        TextButton(onClick = {}, modifier = Modifier.height(10.dp).background(Color.Green)) {
            Text(text = "Создать пользователя")
        }
    }
}





@Composable
fun RadioButtonSingleSelection(modifier: Modifier = Modifier) {
    val radioOptions = listOf("Даю согласие на обработку персональных данных")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null // null recommended for accessibility with screen readers
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
fun CardCheeeck(){
    var clicked by remember { mutableStateOf(false) }
    var icon = if (clicked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
    var iconColor = if (clicked) Color(0xFFF87265) else Color.Black

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(160.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier) {
            Column(Modifier.padding(9.dp)) {
                FilledTonalButton(
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),

                    colors = ButtonColors(
                        containerColor = Color(0xFFF7F7F9),
                        disabledContainerColor = Color.Gray,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray
                    ),
                    onClick = {
                        clicked = !clicked

                    }) {
                    Icon(icon, "Like",
                        tint = iconColor)
                }
                Image(
                    painter = painterResource(R.drawable.card_krosovok),
                    contentDescription = "Krosovok",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(70.dp)
                )
                Text(
                    text = "BEST SELLER",
                    color = Color(0xFF48B2E7),
                    fontSize = 12.sp)
                Spacer(Modifier.size(8.dp))

                Text(
                    text = "Nike Air Max",
                    color = Color(0xFF6A6A6A),
                    fontSize = 16.sp)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = " ₽ 752.00",
                    modifier = Modifier.padding(9.dp))
                MyIconShape()
            }
        }
    }

}

@Composable
fun MyCardButton(){
    var clicked by remember { mutableStateOf(false) }
    var icon = if (clicked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
    var iconColor = if (clicked) Color.Red else Color.Black

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(160.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier) {
            Column(Modifier.padding(9.dp)) {
                FilledTonalButton(
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),

                    colors = ButtonColors(
                        containerColor = Color(0xFFF7F7F9),
                        disabledContainerColor = Color.Gray,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray
                    ),
                    onClick = {
                        clicked = !clicked

                    }) {
                    Icon(icon, "Like",
                        tint = iconColor)
                }
            }
        }
    }
}


@Composable
@Preview()
fun PreviewCheeeck(){
    CardCheeeck()
}

