package com.example.newsapp.core

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ManageResources {

    fun manageRes(@StringRes id: Int): String

}

class ManageResourcesImpl @Inject constructor(@ApplicationContext private val context: Context) : ManageResources {

    override fun manageRes(id: Int): String = context.getString(id)

}