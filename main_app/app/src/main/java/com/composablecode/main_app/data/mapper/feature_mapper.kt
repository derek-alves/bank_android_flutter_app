package com.composablecode.main_app.data.mapper

import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.infra.flutter.flutter_api.Feature

fun Feature.toDomain(): FeatureModel {
    return FeatureModel(
        name = this.name,
        route = this.route
    )
}


fun FeatureModel.toFeature(): Feature {
    return Feature(
        name = this.name,
        route = this.route
    )
}