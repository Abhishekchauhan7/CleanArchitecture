package com.abhi.androidarchitecture.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.abhi.androidarchitecture.data.DataManager.DataManager
import com.abhi.androidarchitecture.data.Scheduler.SchedulerProvider
import com.abhi.androidarchitecture.data.remote.ApiEndPoint
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>: ViewModel {

    private var mDataManager: DataManager?=null
    private var mApiService: ApiEndPoint?=null
    private var mcontext: Application?=null
    private val mIsLoading = ObservableBoolean(false)
    private var mCompositeDisposable: CompositeDisposable?=null
    private var mSchedulerProvider: SchedulerProvider?= null

    private var mNavigator: WeakReference<N>? = null
    constructor(dataManager: DataManager ,apiService: ApiEndPoint ,schedulerProvider:SchedulerProvider ){
        mDataManager = dataManager
        mApiService = apiService
        mSchedulerProvider  = schedulerProvider
        this.mCompositeDisposable = CompositeDisposable()

    }





    override fun onCleared() {
        mCompositeDisposable!!.dispose()
        super.onCleared()
    }



    fun getCompositeDisposable(): CompositeDisposable? {
        return mCompositeDisposable
    }


    fun getDataManager(): DataManager? {
        return mDataManager
    }

    fun getApiService():ApiEndPoint?{
        return  mApiService
    }


    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

    fun getNavigator(): N? {
        return mNavigator!!.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }


    fun getSchedulerProvider(): SchedulerProvider? {
        return mSchedulerProvider
    }


}