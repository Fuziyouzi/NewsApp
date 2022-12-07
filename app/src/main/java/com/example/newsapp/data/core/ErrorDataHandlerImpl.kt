package com.example.newsapp.data.core

import com.example.newsapp.domain.models.DomainError
import com.example.newsapp.domain.models.NoInternetConnection
import com.example.newsapp.domain.models.ServiceIsUnavailable
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorDataHandlerImpl @Inject constructor(): ErrorDataHandler {

    override fun handle(e: Exception): DomainError = when (e) {
            is UnknownHostException -> NoInternetConnection()
            else -> ServiceIsUnavailable()
    }
}