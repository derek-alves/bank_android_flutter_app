package com.composablecode.main_app.app

import android.app.Application
import com.composablecode.main_app.di.homeModule
import com.composablecode.main_app.infra.di.flutterDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(listOf(flutterDiModule,homeModule))
        }
    }
}