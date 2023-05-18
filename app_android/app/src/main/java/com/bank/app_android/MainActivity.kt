package com.bank.app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.bank.app_android.databinding.FragmentMailPageBinding
import com.bank.app_android.databinding.FragmentSettingsBinding
import com.bank.app_android.ui.components.*
import com.bank.app_android.ui.pages.home.Home
import com.bank.app_android.ui.pages.mail.Mail
import com.bank.app_android.ui.pages.mail.MailRvAdapter
import com.bank.app_android.ui.pages.settings.Card
import com.bank.app_android.ui.pages.settings.CardRvAdapter
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
                    Screen()
                }
            }
        }
    }
}


@Composable
fun Screen() {
    val cards = listOf<Card>(
        Card("2213  4563  6789  6457", "Chika Adien Aulya", ""),
        Card("2213  4563  6789  6457", "Chika Adien Aulya", ""),
    )
    AndroidViewBinding(FragmentSettingsBinding::inflate) {
        val cardAdapter = CardRvAdapter(cards)
        with(this.rvCards) {
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    BankTheme {
        Screen()
    }
}




