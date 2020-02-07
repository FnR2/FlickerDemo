package com.visual.flickerdemo

import android.app.Application
import dagger.android.HasActivityInjector

class DemoApplication : Application(), HasActivityInjector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun activityInjector() = appComponent.activityInjector
}