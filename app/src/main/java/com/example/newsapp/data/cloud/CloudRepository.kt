package com.example.newsapp.data.cloud


import android.util.Log
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.NewsRepository
import com.example.newsapp.domain.RoomRepository
import java.security.Key
import javax.inject.Inject

class CloudRepository @Inject constructor(
    private val api: NewsService,
    private val handelDataRequest: HandelDataRequest
) : NewsRepository {

    override suspend fun getNews(): List<NewsModel> =
        handelDataRequest.handleRequest {
            api.getNews(KEY_API, "ua")
        }


    override suspend fun getNewsByCountry(nameCountry: String): List<NewsModel> =
        handelDataRequest.handleRequest {
            api.getNewsByCountry(
                KEY_API,
                nameCountry
            )
        }

    override suspend fun getNewsByTopics(topic: String): List<NewsModel> =
        handelDataRequest.handleRequest {
            api.getNewsByTopics(
                KEY_API,
                "us",
                topic
            )
        }

    companion object{
        private const val KEY_API = "ed75fabb17904321875699bc74ff3408"
    }
}