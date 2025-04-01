package com.composablecode.main_app.infra.flutter.flutter_api

import com.composablecode.main_app.infra.flutter.flutter_communication.FlutterCommunicationChannel
import com.composablecode.main_app.infra.flutter.flutter_communication.MicroApp
import com.composablecode.main_app.infra.flutter.flutter_communication.Route
import io.flutter.embedding.engine.FlutterEngine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FlutterApiServiceImpl(
    private val flutterEngine: FlutterEngine
): FlutterApiService {
    private val featureFlutterApi = FlutterCommunicationChannel(flutterEngine.dartExecutor.binaryMessenger)

    override suspend fun syncFeatures(): Result<List<Feature>> =
        suspendCoroutine { continuation ->
            featureFlutterApi.syncFeatures { result ->

                val mappedResult = result.map { microApps ->
                    microApps.map { microApp ->
                        Feature(name = microApp.name, route = microApp.route)
                    }
                }
                continuation.resume(mappedResult)
            }
        }

    override fun pushFeature(feature: Feature, arguments: Map<String,String >) {
        featureFlutterApi.navigateTo(
            Route(path = feature.route, data = arguments),
            callback = {}
        )
    }
}