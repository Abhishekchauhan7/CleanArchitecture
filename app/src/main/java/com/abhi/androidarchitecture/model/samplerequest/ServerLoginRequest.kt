package com.abhi.androidarchitecture.model.createdemorequest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ServerLoginRequest(
    @field:Expose
    @field:SerializedName("first_name")
    val first_name: String?,
    @field:Expose
    @field:SerializedName("last_name")
    val last_name: String?,
    @field:Expose
    @field:SerializedName("email")
    val email: String?,
    @field:Expose
    @field:SerializedName("country_code")
    val country_code: String?,
    @field:Expose
    @field:SerializedName("mobile_number")
    val mobile_number: String?,
    @field:Expose
    @field:SerializedName("country")
    val country: String?
) {

    override fun equals(`object`: Any?): Boolean {
        if (this === `object`) {
            return true
        }
        if (`object` == null || javaClass != `object`.javaClass) {
            return false
        }

        val that = `object` as ServerLoginRequest?

        if (if (email != null) email != that!!.email else that!!.email != null) {
            return false
        }
        return if (first_name != null) first_name == that.first_name else that.first_name == null
    }


}
