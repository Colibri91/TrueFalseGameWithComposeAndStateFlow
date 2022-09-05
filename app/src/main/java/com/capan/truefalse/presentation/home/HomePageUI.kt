package com.capan.truefalse.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.capan.truefalse.R
import com.capan.truefalse.ui.theme.TruefalseTheme

/**
 * Created by R. Mert Dolar on 5.09.2022.
 */

@Composable
fun HomePageUI(name: String) {
    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TruefalseTheme {
        HomePageUI(name = "Hello")
    }
}
