package com.composablecode.main_app.app.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bank.app_android.ui.theme.*
import com.composablecode.main_app.presentation.ui.components.HomeNavHost


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BankTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface,
                ) {
                    HomeNavHost()
                }
            }
        }
    }


}

//https://github.dev/caosytrung/AndroidMultiFlutterModules/blob/master/app/src/main/java/com/trungcs/multifluttersintoandroid/flutter/first_module/FlutterFirstModuleActivity.kt







