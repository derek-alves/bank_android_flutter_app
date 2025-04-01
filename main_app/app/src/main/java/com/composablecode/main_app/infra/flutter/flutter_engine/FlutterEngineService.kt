package com.composablecode.main_app.infra.flutter.flutter_engine

import android.content.Context
import android.util.Log
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class FlutterEngineService  {
    fun initializeEngine(context: Context): FlutterEngine {
        Log.d("FlutterEngineService", "🟢 Init FlutterEngine")
        val flutterEngine = FlutterEngine(context)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        FlutterEngineCache.getInstance().put(ENGINE_ID, flutterEngine)
        return flutterEngine
    }

    companion object{
        const val ENGINE_ID = "flutter_engine"
    }
}