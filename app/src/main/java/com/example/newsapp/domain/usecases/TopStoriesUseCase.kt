package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.NewsResult

interface TopStoriesUseCase {

    suspend fun getTopStories(): NewsResult<List<NewsModel>, String>

}