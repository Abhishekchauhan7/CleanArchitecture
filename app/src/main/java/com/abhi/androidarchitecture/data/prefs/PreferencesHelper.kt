package com.abhi.androidarchitecture.data.prefs

import com.abhi.androidarchitecture.data.DataManager.DataManager


interface PreferencesHelper {

    var accessToken: String

    var currentUserEmail: String

    var currentUserId: Long?

    val currentUserLoggedInMode: Int

    var currentUserName: String

    var currentUserProfilePicUrl: String

    fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode)
}
