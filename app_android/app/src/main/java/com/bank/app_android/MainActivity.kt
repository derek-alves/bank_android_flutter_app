package com.bank.app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.bank.app_android.databinding.FragmentSettingsBinding
import com.bank.app_android.ui.pages.home.Home
import com.bank.app_android.ui.pages.home.settings.Card
import com.bank.app_android.ui.pages.home.settings.CardRvAdapter
import com.bank.app_android.ui.theme.*


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface,
                ) {
                    Home()
                }
            }
        }
    }
}




//@Preview(showBackground = true)
//@Composable
//fun PreviewScreen() {
//    BankTheme {
//        Screen()
//    }
//}




