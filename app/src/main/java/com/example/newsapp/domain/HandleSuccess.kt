package com.example.newsapp.domain

import com.example.newsapp.R
import com.example.newsapp.core.ManageResources
import javax.inject.Inject

interface HandleSuccess<T> {

    suspend fun handle(): T
}

class HandleSuccessImpl @Inject constructor(
    private val resources: ManageResources)
    :HandleSuccess<String> {


    override suspend fun handle() = resources.manageRes(R.string.done)

}