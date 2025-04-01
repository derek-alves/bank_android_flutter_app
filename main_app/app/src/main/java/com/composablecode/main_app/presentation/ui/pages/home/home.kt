package com.composablecode.main_app.presentation.ui.pages.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.navigation.compose.rememberNavController
import com.composablecode.main_app.R
import com.composablecode.main_app.presentation.routes.NavigationHost
import com.bank.app_android.ui.components.BottomMenuContent
import com.bank.app_android.ui.components.CustomBottomBar


@Composable
fun Home() {
    val navController = rememberNavController()
    Scaffold() { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController = navController)
            Layout(content = {
                CustomBottomBar(
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    },

                    items = listOf(
                        BottomMenuContent("profile", "profile", R.drawable.profile),
                        BottomMenuContent("charts", "chart", R.drawable.chart),
                        BottomMenuContent("mail", "mail", R.drawable.mail),
                        BottomMenuContent("settings", "settings", R.drawable.settings),

                        ),
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }) { measurable, constraints ->
                val placeable = measurable[0].measure(constraints)
                layout(constraints.maxWidth, constraints.maxHeight) {
                    placeable.place(0, constraints.maxHeight - placeable.height)
                }
            }
        }
    }
}