package com.bank.app_android.routes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bank.app_android.ui.pages.home.profile.ProfilePage
import com.bank.app_android.ui.pages.mail.MailPage

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") {
            ProfilePage()
        }
        composable("chart") {
            AnyScreen()
        }
        composable("mail") {
           MailPage()
        }
        composable("settings") {
            AnyScreen()
        }
    }
}

@Composable
fun AnyScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue))
}