package com.bank.app_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.bank.app_android.ui.theme.orangeGradient

@Composable
fun PrimaryButton(
    modifier: Modifier,
    text: String,
    shape: Shape = MaterialTheme.shapes.large,
    onPressed: () -> Unit,
){
    Button(
        shape = shape,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onPressed() },
    ) {
        Box(
            modifier = modifier
                .background(
                    Brush.horizontalGradient(colorStops = orangeGradient),
                )
                .then(modifier)
                .padding(
                    horizontal = 16.dp,
                )
                .height(58.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text=text,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}