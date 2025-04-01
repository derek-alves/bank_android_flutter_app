package com.bank.app_android.ui.pages.home.settings


import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import com.bank.app_android.ui.pages.mail.MailViewHolder

class CardRvAdapter(private val cards: List<Card>): RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int {
      return  cards.size
    }


}

