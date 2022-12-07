package com.example.newsapp.data.models

import com.example.newsapp.core.Mapper
import com.example.newsapp.domain.models.NewsModel

data class NewsApiResponce(
    val articles: List<NewsHeadlines>,
    val status: String,
    val totalResults: Int
) : Mapper<List<NewsModel>> {

    override fun map(): List<NewsModel> = articles.map { it.map() }

}
