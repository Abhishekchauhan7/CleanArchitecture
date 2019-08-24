package com.abhi.androidarchitecture.data.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.abhi.androidarchitecture.util.constants.AppConstants.LOGGED_IN_PREF
import com.abhi.androidarchitecture.util.constants.AppConstants.RESPONSE_CODE


object SaveSharedPreference {


     private fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }


    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(LOGGED_IN_PREF, loggedIn)
        editor.apply()
    }


    fun setResponseCode(context: Context, responsecode: String) {
        val editor = getPreferences(context).edit()
        editor.putString(RESPONSE_CODE, responsecode)
        editor.apply()
    }

    fun getResponseCode(context: Context): String {
        return getPreferences(context).getString(RESPONSE_CODE, "")
    }

    fun getLoggedStatus(context: Context): Boolean {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false)
    }
}