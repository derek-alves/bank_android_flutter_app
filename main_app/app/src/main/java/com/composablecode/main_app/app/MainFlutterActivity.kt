package com.composablecode.main_app.app

import android.content.Context
import android.content.Intent
import com.composablecode.main_app.infra.flutter.flutter_engine.MainFlutterEngineHandler
import io.flutter.embedding.android.FlutterActivity

class MainFlutterActivity: FlutterActivity() {

    private fun buildWithCachedEngine(context: Context): Intent {
        return FlutterActivity.CachedEngineIntentBuilder(
            MainFlutterActivity::class.java,
            MainFlutterEngineHandler.ENGINE_ID
        ).build(context).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
    }

    companion object{

    }
}