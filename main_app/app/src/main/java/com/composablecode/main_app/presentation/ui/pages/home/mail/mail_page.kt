package com.composablecode.main_app.presentation.ui.pages.home.mail

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.bank.app_android.ui.pages.mail.Mail
import com.bank.app_android.ui.pages.mail.MailRvAdapter
import com.composablecode.main_app.databinding.FragmentMailPageBinding

@Composable
fun MailPage(){
    AndroidViewBinding(FragmentMailPageBinding::inflate) {
        val mailList = mutableListOf<Mail>(
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),

            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            ),
            Mail(
                "DW to DW",
                description = "Send Money to anyone that registered on DW. Register link will be sent, if they are not yet registered."
            )
        )
        val mailAdapter = MailRvAdapter(mailList)
        with(this.rvMail) {
            adapter = mailAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

    }
}