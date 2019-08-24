package com.abhi.androidarchitecture.dagger.module

import android.app.Application
import android.content.Context
import com.abhi.androidarchitecture.dagger.PreferenceInfo
import com.abhi.androidarchitecture.data.DataManager.AppDataManager
import com.abhi.androidarchitecture.data.DataManager.DataManager
import com.abhi.androidarchitecture.data.Scheduler.AppSchedulerProvider
import com.abhi.androidarchitecture.data.Scheduler.SchedulerProvider
import com.abhi.androidarchitecture.data.prefs.AppPreferencesHelper
import com.abhi.androidarchitecture.data.prefs.PreferencesHelper
import com.abhi.androidarchitecture.data.remote.ApiHelper
import com.abhi.androidarchitecture.data.remote.AppApiHelper
import com.abhi.androidarchitecture.util.constants.AppConstants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }


    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }


    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }


    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}