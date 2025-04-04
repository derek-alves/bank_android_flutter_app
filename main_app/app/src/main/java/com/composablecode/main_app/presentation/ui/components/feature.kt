package com.composablecode.main_app.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bank.app_android.ui.theme.brownGradientColor
import com.composablecode.main_app.R
import com.composablecode.main_app.domain.model.FeatureModel


@Composable
fun Feature(modifier: Modifier = Modifier, featureModel: FeatureModel, onClick: () -> Unit = {}) {
    Column(modifier = modifier.clickable {
        onClick.invoke()
    }, horizontalAlignment = Alignment.CenterHorizontally) {
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
        Text(
            featureModel.name,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Light)
        )
    }
}