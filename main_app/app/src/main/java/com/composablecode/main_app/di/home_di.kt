package com.composablecode.main_app.di

import com.composablecode.main_app.data.repository.ExternalFeatureRepositoryImpl
import com.composablecode.main_app.domain.repository.ExternalFeatureRepository
import com.composablecode.main_app.domain.usecase.GetExternalFeaturesUseCase

import com.composablecode.main_app.presentation.view_model.home.HomeViewmodel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory<ExternalFeatureRepository> { ExternalFeatureRepositoryImpl(get()) }
    factory<GetExternalFeaturesUseCase> { GetExternalFeaturesUseCase(get()) }
    viewModel { HomeViewmodel(get()) }
}