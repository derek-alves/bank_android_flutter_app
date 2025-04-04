package com.composablecode.main_app.di

import com.composablecode.main_app.data.repository.ExternalFeatureRepositoryImpl
import com.composablecode.main_app.domain.repository.ExternalFeatureRepository
import com.composablecode.main_app.domain.usecase.GetExternalFeaturesUseCase
import com.composablecode.main_app.domain.usecase.PushExternalFeatureUseCase
import org.koin.dsl.module

val externalFeatureModule = module {
    factory<ExternalFeatureRepository> { ExternalFeatureRepositoryImpl(get()) }
    factory<GetExternalFeaturesUseCase> { GetExternalFeaturesUseCase(get()) }
    factory { PushExternalFeatureUseCase(get()) }
}