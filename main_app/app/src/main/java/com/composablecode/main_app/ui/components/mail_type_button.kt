package com.bank.app_android.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.res.use
import android.widget.RelativeLayout
import com.composablecode.main_app.R
import com.composablecode.main_app.databinding.MailTypeButtonBinding


@SuppressLint("UseCompatLoadingForDrawables")
class MailTypeButton(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    private var pressedButton: Boolean = false
    private val binding: MailTypeButtonBinding = MailTypeButtonBinding.inflate(
        LayoutInflater.from(context), this, true,
    )

    init {
        context.obtainStyledAttributes(attrs, R.styleable.MailTypeButton).use {
            binding.type.text = it.getString(R.styleable.MailTypeButton_type)
            pressedButton = it.getBoolean(
                R.styleable.MailTypeButton_selected,
                true
            )
            setPressedButton()

        }


    }

    private fun setPressedButton() {
        binding.mailTypeButton.background = if (pressedButton)
            resources.getDrawable(
                R.drawable.button_gradient,
                context.theme
            )
        else
            resources.getDrawable(R.drawable.button_outilined, context.theme)

        pressedButton = !pressedButton
    }

}