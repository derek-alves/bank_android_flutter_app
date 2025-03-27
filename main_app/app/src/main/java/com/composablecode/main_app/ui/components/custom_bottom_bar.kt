package com.bank.app_android.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bank.app_android.ui.theme.greyGradient
import com.bank.app_android.ui.theme.neutralGradientColor
import com.bank.app_android.ui.theme.orangeGradient
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

@Composable
fun CustomBottomBar(
    items: List<BottomMenuContent>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomMenuContent) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(start = 32.dp, end = 32.dp, bottom = 16.dp)
            .height(58.dp)
            .border(
                1.dp,
                Color.White.copy(alpha = 0.15f),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp,
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )
            .fillMaxWidth(),
    ) {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .blur(5.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(colorStops = greyGradient),
                    alpha = 0.9f
                )
                .then(modifier)
        )
        val backStackEntry = navController.currentBackStackEntryAsState()

        NavigationBar(
            containerColor = Color.Transparent,
            tonalElevation = 0.dp,
            modifier = modifier.padding(horizontal = 8.dp)
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route

                NavigationBarItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconId),
                            contentDescription = "icons",
                            modifier = modifier
                                .size(24.dp)
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(
                                            Brush.linearGradient(
                                                colorStops = if (selected) orangeGradient else neutralGradientColor
                                            ),
                                            blendMode = BlendMode.SrcIn
                                        )
                                    }
                                },
                            tint = Color.White // still applies, but Material 3 allows more control via color providers
                        )
                    }
                )
            }
        }

    }

}

data class BottomMenuContent(
    val title: String,
    val route: String,
    @DrawableRes val iconId: Int,
)


