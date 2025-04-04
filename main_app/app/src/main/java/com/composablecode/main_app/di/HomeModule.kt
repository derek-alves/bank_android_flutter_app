package com.composablecode.main_app.di

import com.composablecode.main_app.presentation.view_model.home.HomeViewmodel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewmodel(get()) }
}