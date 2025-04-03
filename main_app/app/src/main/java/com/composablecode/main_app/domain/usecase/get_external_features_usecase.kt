package com.composablecode.main_app.domain.usecase

import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.domain.repository.ExternalFeatureRepository

class GetExternalFeaturesUseCase(private val repository: ExternalFeatureRepository){
    suspend fun  get():  List<FeatureModel> {
        return repository.getFeatures()
    }
}