package com.example.newsapp.presenter.main


import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelFragment @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {


}