package com.capan.truefalse

import android.app.Application
import com.capan.truefalse.di.appModule
import com.capan.truefalse.di.firebaseModule
import com.capan.truefalse.di.questionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber
import timber.log.Timber.Forest.plant


class TrueFalseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        injectKoin()
        injectTimber()
    }

    private fun injectKoin(){
        startKoin{
            androidLogger()
            androidContext(this@TrueFalseApplication)
            modules(appModule, questionModule, firebaseModule)
        }
    }

    private fun injectTimber(){
        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
    }
}