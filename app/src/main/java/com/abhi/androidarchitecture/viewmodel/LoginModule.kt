package com.abhi.androidarchitecture.viewmodel

import com.abhi.androidarchitecture.data.DataManager.DataManager
import com.abhi.androidarchitecture.data.Scheduler.SchedulerProvider
import com.abhi.androidarchitecture.data.remote.ApiEndPoint
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun ProvideViewModel(dataManager: DataManager,apiEndPoint: ApiEndPoint,schedulerProvider: SchedulerProvider):LoginViewModel{

        return LoginViewModel(dataManager,apiEndPoint,schedulerProvider)
    }
}