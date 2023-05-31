package com.bank.app_android.infra.routes


import android.opengl.Visibility
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bank.app_android.databinding.CustomAppBarBinding
import com.bank.app_android.ui.pages.home.profile.ProfilePage
import com.bank.app_android.ui.pages.home.settings.SettingPage
import com.bank.app_android.ui.pages.mail.MailPage

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") {
            ProfilePage()
        }
        composable("chart") {
            AnyPage()
        }
        composable("mail") {
            MailPage()
        }
        composable("settings") {
            SettingPage()
        }
    }
}

@Composable
fun AnyPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
    ) {
        CustomAppBar()
    }
}

@Composable
private fun CustomAppBar() {
    AndroidViewBinding(CustomAppBarBinding::inflate) {
        title.text = "Chart"
        backBtn.visibility = View.GONE

    }
}