package com.bank.app_android.ui.pages.mail

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.bank.app_android.databinding.FragmentMailPageBinding

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