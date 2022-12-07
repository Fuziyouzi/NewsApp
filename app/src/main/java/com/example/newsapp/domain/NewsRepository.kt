package com.example.newsapp.domain

import com.example.newsapp.domain.models.NewsModel

interface NewsRepository {

   suspend fun getNews(): List<NewsModel>

   suspend fun getNewsByCountry(nameCountry: String ): List<NewsModel>

   suspend fun getNewsByTopics(topic: String): List<NewsModel>
}