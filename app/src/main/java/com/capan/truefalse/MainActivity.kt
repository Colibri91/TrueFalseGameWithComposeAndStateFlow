package com.capan.truefalse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.capan.truefalse.presentation.game.GamePageUI
import com.capan.truefalse.presentation.home.HomePageUI
import com.capan.truefalse.ui.theme.TruefalseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TruefalseTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                var modifier = Modifier
                NavHost(navController = navController, startDestination = "homePageUI") {
                    composable("homePageUI") { HomePageUI(modifier, navController) }
                    composable("gamePageUI") { GamePageUI(modifier, navController) }
                }
                /*Surface(
                    modifier = modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box() {
                        HomePageUI(modifier = modifier.align(Alignment.TopCenter))
                    }
                }*/
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TruefalseTheme {
        //HomePageUI(Modifier)
    }
}