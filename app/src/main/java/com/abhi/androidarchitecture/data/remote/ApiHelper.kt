package com.abhi.androidarchitecture.data.remote


import com.abhi.androidarchitecture.model.createdemo.CreateDemoResponse
import com.abhi.androidarchitecture.model.createdemorequest.ServerLoginRequest
import io.reactivex.Single

interface ApiHelper {


     fun doServerDemoApiCall(request: ServerLoginRequest): Single<CreateDemoResponse>


}