package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.domain.models.NewsResult

interface UserUseCase {

    suspend fun getUserCountry(): NewsResult<String, String>

    suspend fun updateUserCountry(country: String): NewsResult<String, String>

    suspend fun getCountry(): NewsResult<List<NewsModel>, String>
}