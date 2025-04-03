package com.composablecode.main_app.infra.flutter.flutter_engine

import android.content.Context
import android.util.Log
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainFlutterEngineHandler: FlutterEngineHandler {
   private lateinit var flutterEngine:FlutterEngine
    override fun getEntryPoint() = ENTRY_POINT
    override fun getEngineID() = ENGINE_ID
    override fun getEngine(): FlutterEngine = flutterEngine

    override fun initializeEngine(context: Context) {
        Log.d("FlutterEngineService", "🟢 Init FlutterEngine")
        flutterEngine = FlutterEngine(context)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(), getEntryPoint()
            )
        )
        FlutterEngineCache.getInstance().put(getEngineID(), flutterEngine)
    }




    companion object{
        const val ENGINE_ID = "main_flutter_engine"
        private const val ENTRY_POINT = "main_module"
    }



}