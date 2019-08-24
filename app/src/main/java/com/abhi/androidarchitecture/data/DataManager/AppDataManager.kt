package com.abhi.androidarchitecture.data.DataManager

import android.content.Context
import com.abhi.androidarchitecture.data.prefs.PreferencesHelper
import com.abhi.androidarchitecture.data.remote.ApiHelper
import com.abhi.androidarchitecture.model.createdemo.CreateDemoResponse
import com.abhi.androidarchitecture.model.createdemorequest.ServerLoginRequest
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppDataManager @Inject
constructor(
    private val mContext: Context,
    private val mApiHelper: ApiHelper,
    private val mPreferencesHelper: PreferencesHelper,
    private val mGson: Gson
) : DataManager {


    override fun doServerDemoApiCall(request: ServerLoginRequest): Single<CreateDemoResponse> {
        return mApiHelper.doServerDemoApiCall(request)
    }


    override var accessToken: String
        get() = mPreferencesHelper.accessToken
        set(accessToken) {
            mPreferencesHelper.accessToken = accessToken!!
        }



    override var currentUserEmail: String
        get() = mPreferencesHelper.currentUserEmail
        set(email) {
            mPreferencesHelper.currentUserEmail = email!!
        }

    override var currentUserId: Long?
        get() = mPreferencesHelper.currentUserId
        set(userId) {
            mPreferencesHelper.currentUserId = userId
        }

    override val currentUserLoggedInMode: Int
        get() = mPreferencesHelper.currentUserLoggedInMode

    override var currentUserName: String
        get() = mPreferencesHelper.currentUserName
        set(userName) {
            mPreferencesHelper.currentUserEmail = userName!!
        }

    override var currentUserProfilePicUrl: String
        get() = mPreferencesHelper.currentUserProfilePicUrl
        set(profilePicUrl) {
            mPreferencesHelper.currentUserProfilePicUrl = profilePicUrl!!
        }


    override fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode)
    }



    override fun setUserAsLoggedOut() {
        updateUserInfo(
            "", null,
            DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT, "", "", ""
        )
    }



    override fun updateUserInfo(
        accessToken: String,
        userId: Long?,
        loggedInMode: DataManager.LoggedInMode,
        userName: String,
        email: String,
        profilePicPath: String
    ) {

        this.accessToken = accessToken
        currentUserId = userId
        setCurrentUserLoggedInMode(loggedInMode)
        currentUserName = userName
        currentUserEmail = email
        currentUserProfilePicUrl = profilePicPath

    }
}

