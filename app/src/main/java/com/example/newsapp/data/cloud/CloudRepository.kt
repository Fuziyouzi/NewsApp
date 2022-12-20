package com.example.newsapp.data.cloud


import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.NewsRepository
import javax.inject.Inject

class CloudRepository @Inject constructor(
    private val api: NewsService,
    private val handelDataRequest: HandelDataRequest
) : NewsRepository {

    override suspend fun getNews(): List<NewsModel> =
        handelDataRequest.handleRequest {
            api.getNews("ed75fabb17904321875699bc74ff3408", "ua")
        }


    override suspend fun getNewsByCountry(nameCountry: String): List<NewsModel> =
        handelDataRequest.handleRequest {
            api.getNewsByCountry(
                "ed75fabb17904321875699bc74ff3408",
                nameCountry
            )
        }

    override suspend fun getNewsByTopics(topic: String): List<NewsModel> =
        handelDataRequest.handleRequest {
            api.getNewsByTopics(
                "ed75fabb17904321875699bc74ff3408",
                "us",
                topic
            )
        }



}