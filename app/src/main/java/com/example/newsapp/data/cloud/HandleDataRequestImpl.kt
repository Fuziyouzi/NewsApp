package com.example.newsapp.data.cloud

import com.example.newsapp.core.Dispatcher
import com.example.newsapp.data.cloud.HandelDataRequest
import com.example.newsapp.data.core.ErrorDataHandler
import com.example.newsapp.data.models.NewsApiResponce
import com.example.newsapp.domain.models.NewsModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HandleDataRequestImpl @Inject constructor(
    private val errorDataHandler: ErrorDataHandler,
    private val dispatcher: Dispatcher
) : HandelDataRequest {


    override suspend fun handleRequest(block: suspend () -> NewsApiResponce): List<NewsModel> =
        withContext(dispatcher.io) {
            try {
                return@withContext block.invoke().map()
            } catch (e: Exception) {
                throw errorDataHandler.handle(e)
            }
        }


}