package com.abhi.androidarchitecture.data.remote

import retrofit2.http.GET

interface ApiEndPoint{


    @GET("/api/users")
    fun GetEmployeeList()

}