package com.bank.app_android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BankTheme(content: @Composable () -> Unit) {
    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = bankColors.primary
        )
    }
    MaterialTheme(
        colors = bankColors,
        typography = bankTypography,
        shapes = bankShapes,
        content = content
    )
}