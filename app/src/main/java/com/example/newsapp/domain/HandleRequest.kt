package com.example.newsapp.domain

import com.example.newsapp.domain.models.*
import javax.inject.Inject

interface HandleRequest {

    suspend fun handle(block: suspend () -> List<NewsModel>): NewsResult<List<NewsModel>, String>

}

class HandleRequestImpl @Inject constructor(
    private val handleError: HandleError<String>
) : HandleRequest {

        override suspend fun handle(block: suspend () -> List<NewsModel>): NewsResult<List<NewsModel>, String> =
        try {
            NewsResult.Success(block.invoke())
        } catch (e: Exception) {
            NewsResult.Failure(handleError.handle(e))
        }




}