package com.abhi.androidarchitecture.dagger.component

import com.abhi.androidarchitecture.dagger.builder.ActivityBuilder
import com.abhi.androidarchitecture.dagger.module.AppModule
import com.abhi.androidarchitecture.dagger.module.NetworkModule
import com.abhi.androidarchitecture.ui.Application.SampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBuilder::class, AppModule::class, AndroidInjectionModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(app: SampleApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: SampleApplication): Builder

        fun build(): AppComponent
    }


}