import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krosovki.R

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
fun ImageList(){

}

// приколл
@Preview
@Composable
fun PreviewSegmentedProgressBarr(){
    SegmentedProgressBar(3, 1)
}