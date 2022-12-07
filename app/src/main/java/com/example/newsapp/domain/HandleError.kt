package com.example.newsapp.domain

import com.example.newsapp.R
import com.example.newsapp.core.ManageResources
import com.example.newsapp.domain.models.NoInternetConnection
import javax.inject.Inject

interface HandleError<T> {

    fun handle(e: Exception): T
}

class HandleErrorImpl @Inject constructor(private val resources: ManageResources): HandleError<String>{
    override fun handle(e: Exception) = resources.manageRes(
        when(e){
            is NoInternetConnection -> R.string.no_internet_connection
            else -> R.string.service_is_unavailable
        }
    )

}