package com.composablecode.main_app.app.activity.flutter

import android.content.Context
import android.content.Intent
import com.composablecode.main_app.domain.model.FeatureModel
import com.composablecode.main_app.infra.flutter.flutter_engine.MainFlutterEngineHandler
import io.flutter.embedding.android.FlutterActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get


object FlutterFeatureLauncher : KoinComponent {
    fun pushFeature(context: Context, featureModel: FeatureModel) {
        CoroutineScope(Dispatchers.Default).launch {
            val flutterViewModel: MainFlutterViewModel = get()
            flutterViewModel.submitAction(MainFlutterAction.PushFeature(featureModel))

            withContext(Dispatchers.Main) {
                val intent = FlutterActivity.CachedEngineIntentBuilder(
                    MainFlutterActivity::class.java,
                    MainFlutterEngineHandler.ENGINE_ID
                )
                    .build(context).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }

                context.startActivity(intent)
            }
        }
    }
}