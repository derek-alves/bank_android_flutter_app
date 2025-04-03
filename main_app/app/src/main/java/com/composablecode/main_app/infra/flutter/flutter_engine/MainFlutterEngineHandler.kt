package com.composablecode.main_app.infra.flutter.flutter_engine

import android.content.Context
import android.content.Intent
import android.util.Log
import com.composablecode.main_app.app.MainFlutterActivity
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainFlutterEngineHandler: FlutterEngineHandler {
   private lateinit var flutterEngine:FlutterEngine
    override fun getEntryPoint() = ENTRY_POINT
    override fun getEngineID() = ENGINE_ID
    override fun getEngine()=  flutterEngine

    override fun initializeEngine(context: Context) {
        Log.d("FlutterEngineService", "🟢 Init FlutterEngine")
        flutterEngine = FlutterEngine(context)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        FlutterEngineCache.getInstance().put(getEngineID(), flutterEngine)

    }




    companion object{
        const val ENGINE_ID = "main_flutter_engine"
        private const val ENTRY_POINT = "main_module"
    }



}