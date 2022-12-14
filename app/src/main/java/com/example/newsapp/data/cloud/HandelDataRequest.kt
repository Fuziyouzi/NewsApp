package com.example.newsapp.data.cloud

import com.example.newsapp.data.models.NewsApiResponce
import com.example.newsapp.domain.models.NewsModel

interface HandelDataRequest {

    suspend fun handleRequest(block: suspend () -> NewsApiResponce): List<NewsModel>
}