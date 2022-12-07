package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.NewsResult

interface TopicsUseCase {

    suspend fun getNewsByCountry(country: String): NewsResult<List<NewsModel>, String>

    suspend fun getNewsByTopic(topic: String): NewsResult<List<NewsModel>, String>

}