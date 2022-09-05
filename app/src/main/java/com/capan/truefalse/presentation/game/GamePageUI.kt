package com.capan.truefalse.presentation.game


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.capan.truefalse.ui.theme.Purple
import com.capan.truefalse.ui.theme.TruefalseTheme
import com.capan.truefalse.utils.customUI.Timer
import com.capan.truefalse.R


/**
 * Created by R. Mert Dolar on 5.09.2022.
 */

@Composable
fun GamePageUI(modifier: Modifier) {

    Box(modifier.fillMaxSize()) {
        Card(
            modifier = modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp),
            backgroundColor = Purple,
        ) {
            Image(
                modifier = modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_game_bg),
                contentScale = ContentScale.Crop,
                contentDescription = "bg_image"
            )
        }
        Box(modifier = modifier.padding(0.dp, 60.dp, 0.dp, 0.dp)) {
            QuestionBoxUI(modifier,"DB is a givible thing which is very important to give someone!")
            Card(
                modifier = modifier.align(Alignment.TopCenter),
                shape = RoundedCornerShape(360.dp),
                backgroundColor = Color.White
            ) {
                TimerUI(modifier, 50L)
            }
        }

        Row(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp, 20.dp, 0.dp, 100.dp),
        ) {
            TrueFalseButton(modifier = modifier,R.drawable.ic_true, title = "true") {

            }
            Spacer(modifier = modifier.size(20.dp))
            TrueFalseButton(modifier = modifier,R.drawable.ic_false, title = "false") {

            }
        }
    }
}

@Composable
private fun TimerUI(modifier: Modifier, time: Long) {
    Box(
        modifier = modifier.padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Timer(
            totalTime = time * 1000L,
            handleColor = Color.Green,
            inactiveBarColor = Color.White,
            activeBarColor = Purple,
            modifier = modifier.size(60.dp)
        )
    }
}

@Composable
private fun QuestionBoxUI(modifier: Modifier,questionText : String) {
    Card(
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth()
            .padding(16.dp, 34.dp, 16.dp, 0.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White,
    ) {
        Column(
            modifier = modifier.padding(16.dp, 44.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier,
                text = "Question 1",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Purple
            )

            Text(
                modifier = modifier.padding(0.dp, 30.dp, 0.dp, 0.dp),
                text = questionText,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun TrueFalseButton(modifier: Modifier,resource : Int, title: String, onClick: () -> Unit) {
    Card(
        modifier = modifier.clickable { onClick() }, elevation = 4.dp,
        shape = RoundedCornerShape(6.dp),
    ) {
        Image(
            modifier = modifier.size(160.dp),
            painter = painterResource(id = resource),
            contentDescription = title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TruefalseTheme {
        GamePageUI(Modifier)
    }
}