package com.composablecode.main_app.infra.flutter.flutter_api


interface FlutterApiService {
    suspend fun syncFeatures():Result<List<Feature>>
    fun pushFeature(feature: Feature, arguments: Map<String, String> = emptyMap())
}

data class Feature(val name: String, val route: String)