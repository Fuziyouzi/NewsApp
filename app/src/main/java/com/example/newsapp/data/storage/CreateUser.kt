package com.example.newsapp.data.storage

import com.example.newsapp.domain.models.NewsModel

data class CreateUser(
    val country: String,
    val list: List<NewsModel>
)