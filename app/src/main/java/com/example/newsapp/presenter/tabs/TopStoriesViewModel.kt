package com.example.newsapp.presenter.tabs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.TopStoriesUseCase
import com.example.newsapp.presenter.base.HandleNewsRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopStoriesViewModel @Inject constructor(
    private val topStories: TopStoriesUseCase,
    private val handleRequest: HandleNewsRequest
) : ViewModel() {


    fun showError() = handleRequest.showError()

    fun showList() = handleRequest.showList()


    fun getNews() = handleRequest.handle(viewModelScope) {
        topStories.getTopStories()
    }


    init {
        getNews()
    }
}