package com.composablecode.main_app.domain.repository

import com.composablecode.main_app.domain.model.FeatureModel

interface ExternalFeatureRepository{
    suspend  fun  getFeatures():  List<FeatureModel>
    fun pushFeature(feature: FeatureModel, arguments: Map<String, String> = emptyMap())
}