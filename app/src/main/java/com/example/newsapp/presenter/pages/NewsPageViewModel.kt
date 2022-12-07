package com.example.newsapp.presenter.pages


import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsPageViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {




}