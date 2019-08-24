package com.abhi.androidarchitecture.viewmodel

import com.abhi.androidarchitecture.base.BaseViewModel
import com.abhi.androidarchitecture.data.DataManager.DataManager
import com.abhi.androidarchitecture.data.Scheduler.SchedulerProvider
import com.abhi.androidarchitecture.data.remote.ApiEndPoint
import com.abhi.androidarchitecture.model.createdemorequest.ServerLoginRequest
import com.abhi.androidarchitecture.navigator.loginNavigator

class LoginViewModel(dataManager: DataManager, apiService: ApiEndPoint, schedulerProvider: SchedulerProvider) :
    BaseViewModel<loginNavigator>(dataManager, apiService, schedulerProvider) {

/*

    fun login() {
        setIsLoading(true)
        getCompositeDisposable()!!.add(getDataManager()!!
            .doServerDemoApiCall(ServerLoginRequest())
            .doOnSuccess { response ->
            }
            .subscribeOn(getSchedulerProvider()!!.io())
            .observeOn(getSchedulerProvider()!!.ui())
            .subscribe({ response ->
                setIsLoading(false)
                getNavigator()!!.onSuccess(response.data.response_code)
            }, { throwable ->
                setIsLoading(false)
                getNavigator()!!.onError(throwable.toString())
            })
        )
    }
*/


}