package com.bank.app_android.ui.pages.home.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import com.bank.app_android.ui.components.CreditCard

class CardViewHolder(
    private val composeView: ComposeView
) : RecyclerView.ViewHolder(composeView) {
    fun bind(card: Card) {
        composeView.setContent {
            Box(modifier = Modifier.padding( start = 26.dp) ){
                CreditCard(
                    card.cardNumber,
                    card.name,
                    card.value,
                    )
            }

        }
    }
}