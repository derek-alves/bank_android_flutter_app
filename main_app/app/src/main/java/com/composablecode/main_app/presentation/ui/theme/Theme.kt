package com.bank.app_android.ui.theme

import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.composablecode.main_app.presentation.ui.theme.bankTypography
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
        colorScheme = bankColors,
        typography = bankTypography,
        shapes = com.composablecode.main_app.presentation.ui.theme.bankShapes,
        content = content
    )
}