package com.composablecode.main_app.infra.routes



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composablecode.main_app.ui.pages.home.profile.ProfilePage
import com.composablecode.main_app.ui.pages.home.settings.SettingPage
import com.composablecode.main_app.ui.pages.mail.MailPage

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
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        CustomAppBar()
    }
}

@Composable
private fun CustomAppBar() {
//    AndroidViewBinding(CustomAppBarBinding::inflate) {
//        title.text = "Chart"
//        backBtn.visibility = View.GONE
//
//    }
}