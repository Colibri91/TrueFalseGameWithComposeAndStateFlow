package com.capan.truefalse.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.capan.truefalse.R
import com.capan.truefalse.ui.theme.Purple
import com.capan.truefalse.ui.theme.TruefalseTheme
import com.capan.truefalse.utils.customUI.buttons.PrimaryButton
import com.capan.truefalse.utils.customUI.buttons.SecondaryButton

/**
 * Created by R. Mert Dolar on 5.09.2022.
 */

@Composable
fun HomePageUI(modifier: Modifier) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(screenHeight * 0.7f),
            shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp),
            backgroundColor = Purple,
        ) {
            Image(
                modifier = modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_main_menu_bg),
                contentScale = ContentScale.Crop,
                contentDescription = "bg_image"
            )

            Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Card(
                    modifier = modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(24.dp),
                    shape = RoundedCornerShape(100.dp),
                    backgroundColor = Color.White,
                ){
                    MainPageAnimation(modifier, R.raw.ic_knowledge_brain)
                }

                Text(text = "True False", fontSize = 46.sp, color = Color.White)

                Spacer(modifier = modifier.padding(30.dp))

                PrimaryButton(modifier = modifier,imageRes = R.drawable.ic_life, text = "More Lives") {

                }

                Spacer(modifier = modifier.padding(20.dp))

                PrimaryButton(modifier = modifier,imageRes = R.drawable.ic_store, text = "More Apps") {

                }

            }
        }
        
        Spacer(modifier = modifier.padding(20.dp))

        SecondaryButton(modifier = modifier, imageRes = R.drawable.ic_play, text = "Play") {

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
