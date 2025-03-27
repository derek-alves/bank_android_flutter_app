package com.composablecode.main_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bank.app_android.ui.pages.home.Home
import com.bank.app_android.ui.theme.*
import dev.flutter.module.features.FeatureFlutterApi
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


class MainActivity : ComponentActivity() {
    private lateinit var flutterEngine: FlutterEngine
    private lateinit var flutterFeaturesApi: FeatureFlutterApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flutterEngine = FlutterEngine(this)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        FlutterEngineCache
            .getInstance()
            .put("flutter_engine", flutterEngine)

        flutterFeaturesApi = FeatureFlutterApi(flutterEngine.dartExecutor.binaryMessenger)

        flutterFeaturesApi.syncFeatures(
            callback = { result ->
                val features =  result.getOrNull()
                features?.forEach { feature ->
                    println("🟡 Feature Name: ${feature.name}")
                }
            }
        )


        setContent {
            BankTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface,
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









