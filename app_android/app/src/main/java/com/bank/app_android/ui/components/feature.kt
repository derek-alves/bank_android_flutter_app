package com.bank.app_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bank.app_android.ui.theme.brownGradientColor
import com.bank.app_android.R

@Composable
fun Feature(modifier: Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .size(57.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(brush = Brush.verticalGradient(colorStops = brownGradientColor))
                .padding(14.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.drawer_icon),
                contentDescription = "aaa",
                modifier = modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = modifier.height(2.dp))
        Text("Transfer", style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Light))
    }
}