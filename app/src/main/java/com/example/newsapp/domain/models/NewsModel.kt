package com.example.newsapp.domain.models

import com.example.newsapp.core.Mapper


data class NewsModel(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val publisherName: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
) : Mapper<Array<String?>> {

    override fun map(): Array<String?> {
        return arrayOf(
            author,
            content,
            description,
            publishedAt,
            publisherName,
            title,
            url,
            urlToImage
        )

    }


}
