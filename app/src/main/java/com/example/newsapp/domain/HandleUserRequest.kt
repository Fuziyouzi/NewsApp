package com.example.newsapp.domain


import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.NewsResult
import javax.inject.Inject

interface HandleUserRequest {

    suspend fun handle(block: suspend () -> String): NewsResult<String, String>

    suspend fun handleUnit(block: suspend () -> Unit): NewsResult<String, String>

}

class HandleUserRequestImpl @Inject constructor(
    private val handleError: HandleError<String>,
    private val handleSuccess: HandleSuccess<String>
) : HandleUserRequest {

    override suspend fun handle(block: suspend () -> String) =
        try {
            NewsResult.Success(block.invoke())
        } catch (e: Exception) {
            NewsResult.Failure(handleError.handle(e))
        }

    override suspend fun handleUnit(block: suspend () -> Unit) =
        try {
            block.invoke()
            NewsResult.Success(handleSuccess.handle())
        } catch (e: Exception) {
            NewsResult.Failure(handleError.handle(e))
        }

}