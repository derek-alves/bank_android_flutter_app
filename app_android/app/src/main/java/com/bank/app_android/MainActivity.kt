package com.bank.app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.bank.app_android.ui.pages.home.Home
import com.bank.app_android.ui.theme.*
import dev.flutter.module.features.FeatureFlutterApi
import dev.flutter.module.features.FeatureHostApi
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.BinaryMessenger


class MainActivity : ComponentActivity() {
    private lateinit var flutterEngine: FlutterEngine
    private lateinit var flutterFeaturesApi: FeatureFlutterApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize FlutterEngine
        flutterEngine = FlutterEngine(this)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        // Cache the FlutterEngine
        FlutterEngineCache
            .getInstance()
            .put("flutter_engine", flutterEngine)

        // Initialize FeatureHostApi with BinaryMessenger
        flutterFeaturesApi = FeatureFlutterApi(flutterEngine.dartExecutor.binaryMessenger)

        // Sync features from Flutter module
        flutterFeaturesApi.syncFeatures(
            callback = { result ->
              val features =  result.getOrNull()
                features?.map { feature-> println(feature.name) }
            }
        )

        setContent {
            BankTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface,
                ) {
                    Home()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        flutterEngine.destroy()
    }
}









