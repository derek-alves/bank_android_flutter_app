package com.bank.app_android.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.composablecode.main_app.R
import com.composablecode.main_app.databinding.CustomAppBarBinding

class CustomAppBar(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    private val binding: CustomAppBarBinding = CustomAppBarBinding.inflate(
        LayoutInflater.from(context), this, true,
    )

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomAppBar)
        binding.title.text = attributes.getString(R.styleable.CustomAppBar_title)
        val showBackButton = attributes.getBoolean(R.styleable.CustomAppBar_showBackButton, true)
        binding.backBtn.visibility = if (showBackButton) View.VISIBLE else View.GONE
    }
}
