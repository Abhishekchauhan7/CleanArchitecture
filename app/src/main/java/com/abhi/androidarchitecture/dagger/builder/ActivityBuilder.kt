package com.abhi.androidarchitecture.dagger.builder

import com.abhi.androidarchitecture.ui.Activity.MainActivity
import com.abhi.androidarchitecture.viewmodel.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = ([LoginModule::class]))
    abstract fun injectVminMainActivity():MainActivity
}