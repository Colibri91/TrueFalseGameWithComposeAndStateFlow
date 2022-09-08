package com.capan.truefalse.utils.customUI.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.capan.truefalse.ui.theme.Purple

/**
 * Created by R. Mert Dolar on 8.09.2022.
 */

@Composable
fun PrimaryButton(modifier: Modifier, imageRes: Int? = null, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier.requiredWidth(200.dp),
        onClick = { onClick },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        if (imageRes != null) {
            Image(painterResource(id = imageRes), imageRes.toString())
            Spacer(modifier = modifier)
        }
        Text(
            modifier = modifier.padding(20.dp, 0.dp),
            text = text,
            fontSize = 18.sp,
            color = Purple)
    }
}

@Composable
fun SecondaryButton(modifier: Modifier, imageRes: Int? = null, text: String, onClick: () -> Unit) {
    Button(modifier = modifier.requiredWidth(200.dp),onClick = { onClick }, colors = ButtonDefaults.buttonColors(backgroundColor = Purple)) {
        if (imageRes != null) {
            Image(painterResource(id = imageRes), imageRes.toString())
            Spacer(modifier = modifier)
        }
        Text(
            modifier = modifier.padding(20.dp, 0.dp),
            text = text,
            fontSize = 18.sp,
            color = Color.White
        )
    }
}