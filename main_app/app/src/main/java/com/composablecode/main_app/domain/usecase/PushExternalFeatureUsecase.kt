package com.composablecode.main_app.domain.usecase

import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.domain.repository.ExternalFeatureRepository

class PushExternalFeatureUseCase(
    private val repository: ExternalFeatureRepository
) {
    fun push(feature:FeatureModel,arguments: Map<String, String> = emptyMap() ){
        repository.pushFeature(
            feature, arguments
        )
    }
}