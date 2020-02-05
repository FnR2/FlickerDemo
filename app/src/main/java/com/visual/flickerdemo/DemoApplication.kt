package com.visual.flickerdemo

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import android.app.Activity
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject





class DemoApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<DemoApplication> {
       return DaggerDemoApplicationComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}