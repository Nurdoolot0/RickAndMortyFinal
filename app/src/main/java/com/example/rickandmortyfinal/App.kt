package com.example.rickandmortyfinal

import android.app.Application
import com.example.rickandmortyfinal.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(AppModule.module)
        }
    }
}