package com.composablecode.main_app.app.di

import com.composablecode.main_app.app.activity.flutter.MainFlutterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainFlutterViewModel(get()) }
}