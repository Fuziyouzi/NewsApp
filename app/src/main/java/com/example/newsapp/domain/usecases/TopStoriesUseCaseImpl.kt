package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.HandleRequest
import com.example.newsapp.domain.NewsRepository
import javax.inject.Inject

class TopStoriesUseCaseImpl @Inject constructor(
    private val repository: NewsRepository,
    private val handleRequest: HandleRequest
) : TopStoriesUseCase {


    override suspend fun getTopStories() = handleRequest.handle { repository.getNews() }


}