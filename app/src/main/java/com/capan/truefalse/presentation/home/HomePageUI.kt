package com.capan.truefalse.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.capan.truefalse.R
import com.capan.truefalse.ui.theme.Purple
import com.capan.truefalse.ui.theme.TruefalseTheme

/**
 * Created by R. Mert Dolar on 5.09.2022.
 */

@Composable
fun HomePageUI(modifier: Modifier) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(screenHeight * 0.7f),
        shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp),
        backgroundColor = Purple,
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_game_bg),
            contentScale = ContentScale.Crop,
            contentDescription = "bg_image"
        )

            Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Card(
                    modifier = modifier
                        .size(200.dp).align(Alignment.CenterHorizontally).padding(24.dp),
                    shape = RoundedCornerShape(100.dp),
                    backgroundColor = Color.White,
                ){
                    MainPageAnimation(modifier, R.raw.ic_knowledge_brain)
                }
            }


    }
}

@Composable
private fun MainPageAnimation(modifier: Modifier,animRes : Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animRes))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)
    LottieAnimation(
        modifier = modifier.fillMaxSize(),
        composition = composition,
        progress = { progress },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TruefalseTheme {
        HomePageUI(Modifier)
    }
}
