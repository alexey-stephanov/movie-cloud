package com.alexstephanov.moviecloud

import android.app.Application
import com.alexstephanov.moviecloud.di.DaggerAppComponent
import com.alexstephanov.moviecloud.di.AppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import timber.log.Timber

class MovieCloudApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Timber.plant(Timber.DebugTree())
    }
}