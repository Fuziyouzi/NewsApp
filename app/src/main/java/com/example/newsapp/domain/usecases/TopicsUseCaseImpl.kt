package com.example.newsapp.domain.usecases


import com.example.newsapp.domain.HandleRequest
import com.example.newsapp.domain.NewsRepository
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.NewsResult
import javax.inject.Inject

class TopicsUseCaseImpl @Inject constructor(
    private val repository: NewsRepository,
    private val handleRequest: HandleRequest
) : TopicsUseCase {


    override suspend fun getNewsByCountry(country: String) =
        handleRequest.handle { repository.getNewsByCountry(country) }

    override suspend fun getNewsByTopic(topic: String): NewsResult<List<NewsModel>, String> =
        handleRequest.handle { repository.getNewsByTopics(topic) }


}
