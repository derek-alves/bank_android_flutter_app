package com.bank.app_android.ui.pages.mail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.composablecode.main_app.databinding.MailCardBinding

class MailViewHolder (
    mailCardBinding: MailCardBinding
): RecyclerView.ViewHolder(mailCardBinding.root){
    private val title = mailCardBinding.cardTitle
    private val description = mailCardBinding.cardDescription

    fun bind(mail: Mail){
        title.text = mail.title
        description.text = mail.description
    }

    companion object {
        fun create(parent: ViewGroup):MailViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = MailCardBinding.inflate(inflater, parent,false)
            return MailViewHolder(itemBinding)
        }
    }
}