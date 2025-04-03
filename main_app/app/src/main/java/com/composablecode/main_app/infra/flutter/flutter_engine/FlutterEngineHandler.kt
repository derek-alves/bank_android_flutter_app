package com.composablecode.main_app.infra.flutter.flutter_engine

import android.content.Context
import android.content.Intent
import io.flutter.embedding.engine.FlutterEngine


interface FlutterEngineHandler {
    fun initializeEngine(context: Context)
    fun getEntryPoint():String
    fun getEngineID(): String
    fun getEngine(): FlutterEngine
}