package com.composablecode.main_app.data.repository

import com.composablecode.main_app.data.mapper.toDomain
import com.composablecode.main_app.data.mapper.toFeature
import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.domain.repository.ExternalFeatureRepository
import com.composablecode.main_app.infra.flutter.flutter_api.FlutterApiService

class ExternalFeatureRepositoryImpl(
    private val flutterApiService: FlutterApiService
): ExternalFeatureRepository {
    override suspend fun getFeatures(): List<FeatureModel> {
        return flutterApiService.syncFeatures()
            .getOrDefault(emptyList()).map { it.toDomain() }
    }

    override fun pushFeature(feature: FeatureModel, arguments: Map<String, String>) {
      flutterApiService.pushFeature( feature.toFeature(), arguments)
    }
}