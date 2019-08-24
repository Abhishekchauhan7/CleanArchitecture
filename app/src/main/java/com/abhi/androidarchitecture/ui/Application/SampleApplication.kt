package com.abhi.androidarchitecture.ui.Application

import android.app.Application
import com.abhi.androidarchitecture.dagger.component.DaggerAppComponent

class SampleApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }
}