package com.abhi.androidarchitecture.data.DataManager

import com.abhi.androidarchitecture.data.prefs.PreferencesHelper
import com.abhi.androidarchitecture.data.remote.ApiHelper


interface DataManager :  PreferencesHelper, ApiHelper {


    fun setUserAsLoggedOut()


    fun updateUserInfo(
        accessToken: String,
        userId: Long?,
        loggedInMode: LoggedInMode,
        userName: String,
        email: String,
        profilePicPath: String
    )

    enum class LoggedInMode private constructor(val type: Int) {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1)
    }
}