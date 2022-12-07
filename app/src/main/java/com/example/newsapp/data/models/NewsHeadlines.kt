package com.example.newsapp.data.models

import com.example.newsapp.core.Mapper
import com.example.newsapp.core.editName
import com.example.newsapp.core.editTime
import com.example.newsapp.domain.models.NewsModel

data class NewsHeadlines(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: NewsSource,
    val title: String,
    val url: String,
    val urlToImage: String,
) : Mapper<NewsModel> {

    override fun map(): NewsModel = NewsModel(
        author = author,
        content = content,
        description = description,
        publishedAt = editTime(publishedAt),
        publisherName = editName(source.name),
        title = title,
        url = url,
        urlToImage = urlToImage
    )

}
