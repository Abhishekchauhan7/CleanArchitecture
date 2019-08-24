package com.abhi.androidarchitecture.data.remote

import com.abhi.androidarchitecture.model.createdemo.CreateDemoResponse
import com.abhi.androidarchitecture.model.createdemorequest.ServerLoginRequest
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject

class AppApiHelper : ApiHelper {


    @Inject
    constructor()


    override fun doServerDemoApiCall(request: ServerLoginRequest): Single<CreateDemoResponse> {
        var data = HashMap<String, String>()
        return Rx2AndroidNetworking.post(ApisEndPoints.ENDPOINT_DEMOACCOUNT)
            .addUrlEncodeFormBodyParameter(request)
            .build()
            .getObjectSingle(CreateDemoResponse::class.java)

    }
}