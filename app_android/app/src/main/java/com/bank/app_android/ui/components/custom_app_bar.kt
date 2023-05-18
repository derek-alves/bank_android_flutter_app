package com.bank.app_android.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.bank.app_android.R
import com.bank.app_android.databinding.CustomAppBarBinding

class CustomAppBar(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    private val binding: CustomAppBarBinding = CustomAppBarBinding.inflate(
        LayoutInflater.from(context), this, true,
    )

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomAppBar)
        binding.title.text = attributes.getString(R.styleable.CustomAppBar_title)
    }
}
