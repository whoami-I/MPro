package com.mike.MPro

import android.app.Application
import android.content.Context
import timber.log.Timber

class MProApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
    companion object{
        lateinit var context: Context
    }
}