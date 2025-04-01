package com.bank.app_android.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val white = Color(0xFFFFFFFF)
val black = Color(0xFF0D0D0D)
val orange = Color(0xffD07C46)
val green = Color(0xff86C65E)
val red = Color(0xffC65E5E)
val dark_orange = Color(0xffB35D43)
val dark_blue = Color(0xff23145C)
val dark_yellow = Color(0xff63501E)

val neutralGradientColor = arrayOf(
    0.0f to Color(0xFFC7C7C7),
    0.7f to white,
    1f to white
)
val brownGradientColor = arrayOf(
    0.0f to Color(0xFFD48C46),
    0.7f to Color(0xFF935F33),
    1f to Color(0xFF532D11)
)


val pinkGradientColor = arrayOf(
    0.0f to Color(0xFFC64B6E),
    0.7f to Color(0xFF8B334C),
    1f to Color(0xFF501C2B)
)

val purpleGradientColor = arrayOf(
    0.0f to Color(0xFF290C31),
    0.7f to Color(0xFF631F76),
    1f to Color(0xFF942EB0)
)

val blueGradientColor = arrayOf(
    0.0f to Color(0xFF140941),
    0.6f to Color(0xFF2E1690),
    1f to Color(0xFF4320D2)
)

val orangeGradient = arrayOf(
    0.0f to Color(0xFFC34675),
    1f to Color(0xFFD18449)
)

val greyGradient = arrayOf(
    0.0f to Color(0xFF2D2D2D) ,
   1f to  Color(0xFF2D2D2D)
)

val bankColors = lightColorScheme(
    primary = black,
    onPrimary = white,
    secondary = orange,
    onSecondary = black,
    error = red,
    onError = white,
    background = black,
    onBackground = white,
    surface = black,
    onSurface = white,
)