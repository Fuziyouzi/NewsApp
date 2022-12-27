package com.example.newsapp.presenter.tabs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.TopicsUseCase
import com.example.newsapp.domain.usecases.UserUseCase
import com.example.newsapp.presenter.base.HandleNewsRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyNewsViewModel @Inject constructor(
    private val handleNewsRequest: HandleNewsRequest,
    private val user: UserUseCase
): ViewModel() {

    fun showLoad() = handleNewsRequest.loading()

    fun showError() = handleNewsRequest.showError()

    fun showList() = handleNewsRequest.showList()

    fun showSuccess() = handleNewsRequest.showSuccess()


   fun updateUserCountry(country: String) = handleNewsRequest.handle(viewModelScope){
       user.updateUserCountry(country)
   }

    fun getCountry() = handleNewsRequest.handle(viewModelScope){
        user.getUserCountry()
    }

    fun getUserNews() = handleNewsRequest.handleNews(viewModelScope){
        user.getCountry()
    }



}