package com.composablecode.main_app.infra.di

import com.composablecode.main_app.infra.flutter.flutter_api.FlutterApiService
import com.composablecode.main_app.infra.flutter.flutter_api.FlutterApiServiceImpl
import com.composablecode.main_app.infra.flutter.flutter_engine.FlutterEngineHandler
import com.composablecode.main_app.infra.flutter.flutter_engine.MainFlutterEngineHandler
import io.flutter.embedding.engine.FlutterEngine
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val flutterDiModule = module {
    single<FlutterEngineHandler> { MainFlutterEngineHandler() }

    single(createdAtStart = true) { get<FlutterEngineHandler>().initializeEngine(androidContext()) }

    single<FlutterApiService> {
        FlutterApiServiceImpl(get())
    }
}