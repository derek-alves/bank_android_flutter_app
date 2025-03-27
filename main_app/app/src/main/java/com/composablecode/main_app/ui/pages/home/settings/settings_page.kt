package com.composablecode.main_app.ui.pages.home.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.bank.app_android.ui.pages.home.settings.Card
import com.bank.app_android.ui.pages.home.settings.CardRvAdapter
import com.composablecode.main_app.databinding.FragmentSettingsBinding

@Composable
fun SettingPage() {
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