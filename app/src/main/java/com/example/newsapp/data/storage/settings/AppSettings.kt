package com.example.newsapp.data.storage.settings

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface AppSettings {

    fun getCurrentUserId(): Long

    fun setUserId(id: Long)

    companion object{

        const val NO_USER_ID = -1L
    }

}

class SharedPrefSettings @Inject constructor(@ApplicationContext context: Context): AppSettings{

    private val userSettingsId = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    override fun getCurrentUserId() = userSettingsId.getLong(CURRENT_USER_ID, AppSettings.NO_USER_ID)


    override fun setUserId(id: Long) {
        userSettingsId.edit()
            .putLong(CURRENT_USER_ID, id )
            .apply()
    }

    companion object{
        private const val CURRENT_USER_ID = "currentId"
    }

}