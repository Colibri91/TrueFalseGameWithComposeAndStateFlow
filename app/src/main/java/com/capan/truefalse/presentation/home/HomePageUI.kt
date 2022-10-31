package com.capan.truefalse.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.*
import com.capan.truefalse.R
import com.capan.truefalse.domain.repository.QuestionsRepositoryImpl
import com.capan.truefalse.domain.usecase.QuestionUseCase
import com.capan.truefalse.ui.theme.Purple
import com.capan.truefalse.ui.theme.TruefalseTheme
import com.capan.truefalse.utils.customUI.buttons.PrimaryButton
import com.capan.truefalse.utils.customUI.buttons.SecondaryButton
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

/**
 * Created by R. Mert Dolar on 5.09.2022.
 */

@Composable
fun HomePageUI(modifier: Modifier, navController: NavController, viewModel: HomePageViewModel = koinViewModel()) {

    val uiState: HomePageUIState by viewModel.uiState.collectAsState()

    when(uiState){
        is HomePageUIState.Success->{
            Timber.d("Successssss")
        }
        is HomePageUIState.Error->{
            Timber.d("Errorrrrrr")
        }
    }

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

            Column(modifier = modifier
                .fillMaxSize()
                .padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Card(
                    modifier = modifier
                        .size(140.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(100.dp),
                    backgroundColor = Color.White,
                ){
                    MainPageAnimation(modifier.fillMaxSize(), R.raw.ic_knowledge_brain)
                }

                Text(text = "True\nFalse", fontSize = 36.sp, style = MaterialTheme.typography.h2, color = Color.White, textAlign = TextAlign.Center, maxLines = 2)

                PrimaryButton(modifier = modifier,imageRes = R.drawable.ic_life, text = "More Lives") {

                }

                Spacer(modifier = modifier.padding(10.dp))

                PrimaryButton(modifier = modifier,imageRes = R.drawable.ic_store, text = "More Apps") {

                }

            }
        }
        
        Spacer(modifier = modifier.padding(20.dp))

        SecondaryButton(modifier = modifier, imageRes = R.drawable.ic_play, text = "Play") {
            navController.navigate("gamePageUI")
        }

        Row(modifier = modifier.padding(0.dp,30.dp), verticalAlignment = Alignment.CenterVertically) {
            MainPageAnimation(modifier.size(50.dp), R.raw.ic_life_anim)
            Text(text = " x 10", color = Purple, fontSize = 20.sp, textAlign = TextAlign.Center)
        }
    }
}

@Composable
private fun MainPageAnimation(modifier: Modifier, animRes : Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animRes))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)
    LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { progress },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TruefalseTheme {
        //HomePageUI(Modifier)
    }
}
