package com.example.newsapp.presenter.tabs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.TopStoriesUseCase
import com.example.newsapp.domain.usecases.UserUseCase
import com.example.newsapp.presenter.base.HandleNewsRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopStoriesViewModel @Inject constructor(
    private val topStories: TopStoriesUseCase,
    private val handleRequest: HandleNewsRequest,
    private val user: UserUseCase
) : ViewModel() {


    fun showError() = handleRequest.showError()

    fun showList() = handleRequest.showList()


    fun getNews() = handleRequest.handleNews(viewModelScope) {
        topStories.getTopStories()
    }


    init {
        getNews()
    }
}