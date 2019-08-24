package com.abhi.androidarchitecture.dagger.module

import com.abhi.androidarchitecture.data.remote.ApiEndPoint
import com.abhi.androidarchitecture.util.constants.AppConstants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Reusable
    @Provides
    @JvmStatic
    fun ProvideApi(retrofit: Retrofit): ApiEndPoint {
        return retrofit.create(ApiEndPoint::class.java)
    }


    @Reusable
    @Provides
    @JvmStatic
    fun ProvideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

}