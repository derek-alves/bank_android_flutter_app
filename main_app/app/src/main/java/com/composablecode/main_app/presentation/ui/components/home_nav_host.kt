package com.composablecode.main_app.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.bank.app_android.ui.components.BottomMenuContent
import com.bank.app_android.ui.components.CustomBottomBar
import com.composablecode.main_app.R
import com.composablecode.main_app.presentation.routes.NavigationHost

@Composable
fun HomeNavHost() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                },
                items = listOf(
                    BottomMenuContent("home", "home", R.drawable.profile),
                    BottomMenuContent("charts", "chart", R.drawable.chart),
                    BottomMenuContent("mail", "mail", R.drawable.mail),
                    BottomMenuContent("settings", "settings", R.drawable.settings),
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController = navController)
        }
    }
}