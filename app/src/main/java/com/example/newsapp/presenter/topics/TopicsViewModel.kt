package com.example.newsapp.presenter.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.TopicsUseCase
import com.example.newsapp.presenter.base.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val useCase: TopicsUseCase,
    private val handleNewsRequest: HandleNewsRequest
) : ViewModel() {

    fun showLoad() = handleNewsRequest.loading()

    fun showError() = handleNewsRequest.showError()

    fun showList() = handleNewsRequest.showList()

    fun getNewsByTopic(topic: String) = handleNewsRequest.handle(viewModelScope){
        useCase.getNewsByTopic(topic)
    }

    fun getNewsByCountry(country: String) = handleNewsRequest.handle(viewModelScope){
        useCase.getNewsByCountry(country)
    }



}