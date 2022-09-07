package com.capan.truefalse.presentation.game


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.capan.truefalse.ui.theme.Purple
import com.capan.truefalse.ui.theme.TruefalseTheme
import com.capan.truefalse.utils.customUI.Timer
import com.capan.truefalse.R


/**
 * Created by R. Mert Dolar on 5.09.2022.
 */

@Composable
fun GamePageUI(modifier: Modifier) {

    val openDialog = remember { mutableStateOf(false) }
    val isQuizResultSuccess = remember { mutableStateOf(false) }

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
            QuestionBoxUI(
                modifier,
                "DB is a givible thing which is very important to give someone!"
            )
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
            TrueFalseButton(modifier = modifier, R.drawable.ic_true, title = "true") {
                openDialog.value = true
                //geçici olarak girildi herhangi bir seçenek success olabilir
                isQuizResultSuccess.value = true
            }
            Spacer(modifier = modifier.size(20.dp))
            TrueFalseButton(modifier = modifier, R.drawable.ic_false, title = "false") {
                openDialog.value = true
                //geçici olarak girildi herhangi bir seçenek success olabilir
                isQuizResultSuccess.value = false
            }
        }
    }

    if (openDialog.value) {
        when(isQuizResultSuccess.value){
            true-> ResultDialog(modifier,"DB is a givible thing, you can give it to anybody!",R.raw.ic_success_anim, openDialog)
            false -> ResultDialog(modifier,"DB is a givible thing, you can give it to anybody!",R.raw.ic_fail_anim, openDialog)
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
private fun QuestionBoxUI(modifier: Modifier, questionText: String) {
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
private fun TrueFalseButton(modifier: Modifier, resource: Int, title: String, onClick: () -> Unit) {
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

@Composable
private fun ResultDialog(modifier: Modifier,message : String,animRes: Int, openDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = {
            openDialog.value = false
        }, DialogProperties(), {
            Card(
                elevation = 4.dp,
                shape = RoundedCornerShape(6.dp),
                backgroundColor = Color.White
            ) {
                Column() {
                    Loader(modifier.align(Alignment.CenterHorizontally),animRes)
                    Text(modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp), textAlign = TextAlign.Center, text = message)
                    Spacer(modifier.padding(0.dp,20.dp))
                    Row(modifier.align(Alignment.CenterHorizontally).padding(0.dp,16.dp)) {
                        Text(modifier = modifier.align(Alignment.CenterVertically),text = "Next", color = Purple, fontSize = 20.sp)
                        Image(modifier = modifier.align(Alignment.CenterVertically),painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = "arrow_right")
                    }
                }
            }
        }
    )
}

@Composable
private fun Loader(modifier: Modifier,animRes : Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animRes))
    LottieAnimation(modifier = modifier.size(200.dp),composition = composition, speed = 2f)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TruefalseTheme {
        GamePageUI(Modifier)
    }
}